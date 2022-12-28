package com.bitc.springproject.controller;


import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.ReviewDto;
import com.bitc.springproject.service.CategoryService;
import com.bitc.springproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private CategoryService categoryService;

//    게임리스트 보기
    @RequestMapping(value = "/game", method= RequestMethod.GET)
    public ModelAndView gameList() throws Exception {
        ModelAndView mv = new ModelAndView("game/gameList");

        // 게임리스트
        List<GameDto> dataList = gameService.selectGameList();
        mv.addObject("dataList", dataList);

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

//    게임 작성
    @RequestMapping("/game/write")
    public String boardWrite() throws Exception {
        return "game/gameWrite";
    }

//    게임작성페이지
    @RequestMapping(value = "/game/write", method= RequestMethod.GET)
    public ModelAndView writeGameCate() throws Exception {
        ModelAndView mv = new ModelAndView("/game/gameWrite");

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }


//    게임작성, 이미지
    @RequestMapping("/game/insertGame")
    public String insertGame(GameDto game, MultipartHttpServletRequest multipart) throws Exception {
        gameService.insertGame(game, multipart);

        return "redirect:/game";
    }

//    게임 상세보기
    @RequestMapping(value = "/game/{gameIdx}", method = RequestMethod.GET)
    public ModelAndView gameDetail(@PathVariable("gameIdx") int gameIdx) throws Exception {
        ModelAndView mv = new ModelAndView("game/gameDetail");

        GameDto game = gameService.selectGameDetail(gameIdx);
        mv.addObject("game", game);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        // 댓글 보기
        List<ReviewDto> reviewList = gameService.reviewList(gameIdx);
        mv.addObject("reviewList", reviewList);

        return mv;
    }

//    리뷰작성
    @ResponseBody
    @RequestMapping(value = "/game/insertReview", method = RequestMethod.POST)
    public Object insertReview(@RequestParam("reviewGameIdx") int reviewGameIdx,
                                @RequestParam("reviewUserId") String reviewUserId,
                                @RequestParam("reviewContents") String reviewContents,
                                @RequestParam("reviewRating") int reviewRating) throws Exception {

        gameService.insertReview(reviewGameIdx, reviewUserId, reviewContents, reviewRating);
        List<ReviewDto> reviewList = gameService.reviewList(reviewGameIdx);

        return reviewList;
    }

}
