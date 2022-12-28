package com.bitc.springproject.mapper;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CommentDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Page<BoardDto> selectBoardList() throws Exception;
    Page<BoardDto> categoryBoardList(int categoryIdx) throws Exception;
    void insertBoard(BoardDto board) throws Exception;
    BoardDto detailBoardList(int idx) throws Exception;
    void boardHitCnt(int idx) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int idx) throws Exception;
    List<CommentDto> commentList(int commentBoardIdx) throws Exception;
    void insertComment(CommentDto comment) throws Exception;

    Page<BoardDto> limitBoard() throws Exception;

    List<BoardDto> limitNotice() throws Exception;
}