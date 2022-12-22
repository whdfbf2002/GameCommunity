package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int reviewIdx;
    private String reviewGame;
    private String boardTitle;
    private String boardContents;
    private String boardUserName;
    private String boardCreateDt;
    private String boardUpdateDt;
    private int boardHitCnt;
    private int boardRecommend;
    private int CategoryIdx;
}