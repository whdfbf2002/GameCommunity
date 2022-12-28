package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private int reviewIdx;
    private int reviewGameIdx;
    private String reviewUserId;
    private int reviewRating;
    private String reviewContents;
    private String reviewCreateDt;

    private String userName;
}