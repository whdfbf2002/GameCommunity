package com.bitc.springproject.service;

import com.bitc.springproject.dto.UserDto;
import com.bitc.springproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(UserDto user) throws Exception {
        userMapper.insertUser(user);
    }

    @Override
    public int userIdCheck(UserDto user) throws Exception {
        return userMapper.userIdCheck(user);
    }

    @Override
    public UserDto loginCheck(String userId, String userPw) throws Exception {
        UserDto userDto = userMapper.loginCheck(userId, userPw);
        return userDto;
    }

    @Override
    public void updateUser(UserDto user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public UserDto newSession(UserDto userInfo) throws Exception {
        UserDto user = userMapper.newSession(userInfo);
        return user;
    }


}
