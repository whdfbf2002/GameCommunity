package com.bitc.springproject.service;

import com.bitc.springproject.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private LikeMapper likeMapper;


    @Override
    public void updateLike(int boardIdx) throws Exception{
        likeMapper.updateLike(boardIdx);
    }

    @Override
    public void updateLikeCancel(int boardIdx) throws Exception{
        likeMapper.updateLikeCancel(boardIdx);
    }


    @Override
    public void insertLike(int boardIdx,String userId) throws Exception{
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("memberId", userId);
//        map.put("bno", bno);
//        sqlsession.insert("likeMapper.insertLike", map);
        likeMapper.insertLike(boardIdx, userId);
    }

    @Override
    public void deleteLike(int boardIdx,String userId)throws Exception{
        likeMapper.deleteLike(boardIdx, userId);
    }

    @Override
    public int likeCheck(int boardIdx,String userId) throws Exception{
        return likeMapper.likeCheck(boardIdx, userId);
    }

    @Override
    public void updateLikeCheck(int boardIdx,String userId)throws Exception{
        likeMapper.updateLikeCheck(boardIdx, userId);
    }

    @Override
    public void updateLikeCheckCancel(int boardIdx,String userId)throws Exception{
        likeMapper.updateLikeCheckCancel(boardIdx, userId);
    }
}
