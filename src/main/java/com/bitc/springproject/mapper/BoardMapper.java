package com.bitc.springproject.mapper;

import com.bitc.springproject.dto.BoardDto;
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

}