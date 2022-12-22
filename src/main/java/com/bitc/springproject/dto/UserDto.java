package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;

    // 관리자 권한
    private String managerYn;
}
