package com.bitc.springproject.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {


    void updateLike(int boardIdx) throws Exception;

    void updateLikeCancel(int boardIdx) throws Exception;

    void insertLike(int boardIdx, String userId) throws Exception;

    void deleteLike(int boardIdx, String userId) throws Exception;

    int likeCheck(int boardIdx, String userId) throws Exception;

    void updateLikeCheck(int boardIdx, String userId) throws Exception;

    void updateLikeCheckCancel(int boardIdx, String userId) throws Exception;
}
