package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int commentIdx;
    private int commentBoardIdx;
    private String commentUserId;
    private String commentContents;
    private String commentCreateDt;

    private String userName;
}
