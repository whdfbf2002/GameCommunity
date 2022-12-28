package com.bitc.springproject.dto;


import lombok.Data;

import java.util.List;

@Data
public class GameDto {
    private int gameIdx;
    private String gameTitle;
    private String gameInfo;
    private String storedFilePath;
    private List<GameFileDto> fileList;

    private double rating;
}
