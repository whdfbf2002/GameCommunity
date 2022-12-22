package com.bitc.springproject.service;

import com.bitc.springproject.dto.UserDto;


public interface UserService {
    void insertUser(UserDto user) throws Exception;

    int userIdCheck(UserDto user) throws Exception;

    UserDto loginCheck(String userId, String userPw) throws Exception;
}
