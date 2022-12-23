package com.bitc.springproject.mapper;

import com.bitc.springproject.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(UserDto user) throws Exception;

    int userIdCheck(UserDto user) throws Exception;

    UserDto loginCheck(String userId, String userPw) throws Exception;

    void updateUser(UserDto user) throws Exception;

    UserDto newSession(UserDto userInfo) throws Exception;
}
