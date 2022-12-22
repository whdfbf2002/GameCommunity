package com.bitc.springproject.service;

public interface LikeService {
    int likeCheck(int boardIdx, String userId) throws Exception;

    void insertLike(int boardIdx, String userId) throws Exception;

    void updateLike(int boardIdx) throws Exception;

    void updateLikeCheck(int boardIdx, String userId) throws Exception;

    void updateLikeCheckCancel(int boardIdx, String userId) throws Exception;

    void updateLikeCancel(int boardIdx) throws Exception;

    void deleteLike(int boardIdx, String userId) throws Exception;
}
