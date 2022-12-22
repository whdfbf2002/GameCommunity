package com.bitc.springproject.service;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.mapper.BoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public Page<BoardDto> selectBoardList(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 10); // 리스트 게시물 수 지정
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto detailBoardList(int idx) throws Exception {
        boardMapper.boardHitCnt(idx);

        BoardDto board = boardMapper.detailBoardList(idx);
        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int idx) throws Exception {
        boardMapper.deleteBoard(idx);
    }


    @Override
    public Page<BoardDto> categoryBoardList(int pageNo, int categoryIdx) throws Exception {
        PageHelper.startPage(pageNo, 10); // 리스트 게시물 수 지정
        return boardMapper.categoryBoardList(categoryIdx);
    }



}
