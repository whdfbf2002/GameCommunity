package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int boardIdx;
    private String boardCategory;
    private String boardTitle;
    private String boardContents;
    private String boardUserName;
    private String boardUserId;
    private String boardCreateDt;
    private String boardUpdateDt;
    private int boardHitCnt;
    private int boardLikeCnt;
    private String boardDeletedYn;

    private int categoryIdx;
    private int commentIdx;
    private int filesIdx;
    private String categoryName;
    private String userId;

    // 필터
    private String type;
    private String keyword;

    private int commentCount;
}
