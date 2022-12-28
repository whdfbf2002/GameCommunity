package com.bitc.springproject.controller;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.CommentDto;
import com.bitc.springproject.service.BoardService;
import com.bitc.springproject.service.CategoryService;
import com.bitc.springproject.service.LikeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LikeService likeService;

//    전체 게시판 리스트
    @RequestMapping(value = "/board/all", method = RequestMethod.GET)
    public ModelAndView openAllBoardList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/allBoardList");

        // 페이지네이션
        PageInfo<BoardDto> boardList = new PageInfo<>(boardService.selectBoardList(pageNum), 10);
        mv.addObject("boardList", boardList);

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

//    세부 게시판 리스트
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView openBoardList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum,
                                      @RequestParam(required = false, defaultValue = "", value = "cateIdx") int categoryIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardList");


        // 페이지네이션
        PageInfo<BoardDto> categoryBoardList = new PageInfo<>(boardService.categoryBoardList(pageNum, categoryIdx), 10);
        mv.addObject("categoryBoardList", categoryBoardList);

        // 카테고리별 선택
        CategoryDto categoryBoard = categoryService.categoryBoard(categoryIdx);
        mv.addObject("categoryBoard", categoryBoard);

        // 말머리 선택 (구)
        List<CategoryDto> subCategoryList = categoryService.subCategoryList(categoryIdx);
        mv.addObject("subCategoryList", subCategoryList);

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

    //    게시판 상세 보기
    @RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardDetail");

        BoardDto board = boardService.detailBoardList(idx);
        mv.addObject("board", board);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        // 댓글 보기
        List<CommentDto> commentList = boardService.commentList(idx);
        mv.addObject("commentList", commentList);

        return mv;
    }

    // 댓글 등록
    @ResponseBody
    @RequestMapping(value = "/board/insertComment", method = RequestMethod.POST)
    public Object insertComment(@RequestParam("commentBoardIdx") int commentBoardIdx,
                                @RequestParam("commentUserId") String commentUserId,
                                @RequestParam("commentContents") String commentContents) throws Exception {

        boardService.insertComment(commentBoardIdx, commentUserId, commentContents);
        List<CommentDto> commentList = boardService.commentList(commentBoardIdx);

        return commentList;
    }

//    글쓰기 페이지
    @RequestMapping(value = "/board/write/cateIdx={categoryIdx}", method= RequestMethod.GET)
    public ModelAndView writeBoard(@PathVariable("categoryIdx") int categoryIdx) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardWrite");

        // 카테고리별 선택
        CategoryDto categoryBoard = categoryService.categoryBoard(categoryIdx);
        mv.addObject("categoryBoard", categoryBoard);

        // 말머리 선택 (구)
        List<CategoryDto> subCategoryList = categoryService.subCategoryList(categoryIdx);
        mv.addObject("subCategoryList", subCategoryList);

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

    @RequestMapping(value ="/board/write", method = RequestMethod.POST)
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);

        return "redirect:/board/all";
    }


//    게시글 추천
    @ResponseBody
    @RequestMapping(value = "/board/updateLike" , method = RequestMethod.POST)
    public int updateLike(int boardIdx, String userId) throws Exception{

        int likeCheck = likeService.likeCheck(boardIdx, userId);

        if(likeCheck == 0) {
            //추천 처음누름
            likeService.insertLike(boardIdx, userId); //like테이블 삽입
            likeService.updateLike(boardIdx);	//게시판테이블 +1
            likeService.updateLikeCheck(boardIdx, userId);//like테이블 구분자 1

        }else if(likeCheck == 1) {
            likeService.updateLikeCheckCancel(boardIdx, userId); //like테이블 구분자0
            likeService.updateLikeCancel(boardIdx); //게시판테이블 - 1
            likeService.deleteLike(boardIdx, userId); //like테이블 삭제
        }
        return likeCheck;
    }



//    게시판 업데이트 페이지
    @RequestMapping(value = "/board/update/{idx}", method = RequestMethod.GET)
    public ModelAndView openUpdateBoard(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardUpdate");

        BoardDto board = boardService.detailBoardList(idx);
        mv.addObject("board", board);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        // 말머리 리스트
        List<CategoryDto> subCategory = categoryService.subCategory();
        mv.addObject("subCategory", subCategory);

        return mv;
    }


//    게시글 수정
    @RequestMapping(value = "/board/update/{idx}", method = RequestMethod.PUT)
    public String updateBoard(BoardDto board, @PathVariable int idx) throws Exception {

        BoardDto boardDto = boardService.detailBoardList(idx);
        board.setBoardIdx(idx);
        boardService.updateBoard(board);


        return "redirect:/board?cateIdx=" + boardDto.getCategoryIdx();
    }


//     게시글 삭제
    @RequestMapping(value = "/board/delete/{idx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
        boardService.deleteBoard(idx);
        BoardDto boardDto = boardService.detailBoardList(idx);

        return "redirect:/board?cateIdx=" + boardDto.getCategoryIdx();
    }

}
