package com.bitc.springproject.service;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CommentDto;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.LikeDto;
import com.github.pagehelper.Page;

import java.util.List;

public interface BoardService {

    // 게시판 전체보기
    Page <BoardDto> selectBoardList(int pageNo) throws Exception;

    // 카테고리별 게시판 보기
    Page <BoardDto> categoryBoardList(int pageNo, int categoryIdx) throws Exception;

    // 게시글 등록
    void insertBoard(BoardDto board) throws Exception;

    // 게시판 상세보기
    BoardDto detailBoardList(int idx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int idx) throws Exception;

    List<CommentDto> commentList(int commentBoardIdx) throws Exception;

    void insertComment(int commentBoardIdx, String commentUserId, String commentContents) throws Exception;

    Page<BoardDto> limitBoard() throws Exception;

    List<BoardDto> limitNotice() throws Exception;

}