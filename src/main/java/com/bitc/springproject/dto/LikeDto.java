package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class LikeDto {
    private int likeNum;
    private int boardIdx;
    private String userId;
}
