package com.bitc.springproject.service;

import com.bitc.springproject.dto.GameDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface GameService {
    List<GameDto> selectGameList() throws Exception;

    void insertGame(GameDto game, MultipartHttpServletRequest multipart) throws Exception;
    GameDto selectGameDetail(int gameIdx) throws Exception;
}
