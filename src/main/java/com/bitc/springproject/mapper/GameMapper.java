package com.bitc.springproject.mapper;

import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.GameFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    List<GameDto> selectGameList() throws Exception ;
    void insertGame(GameDto game) throws Exception;
    void insertGameFileList(List<GameFileDto> fileList) throws Exception;
    GameDto selectGameDetail(int gameIdx) throws Exception;
}
