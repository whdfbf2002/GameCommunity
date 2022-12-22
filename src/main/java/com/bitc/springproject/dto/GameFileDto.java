package com.bitc.springproject.dto;

import lombok.Data;

@Data
public class GameFileDto {
    private int gameFileIdx;
    private int gameIdx;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private String createDt;
}
