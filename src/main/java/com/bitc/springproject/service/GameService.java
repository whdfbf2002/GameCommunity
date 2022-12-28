package com.bitc.springproject.service;

import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.ReviewDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface GameService {
    List<GameDto> selectGameList() throws Exception;

    void insertGame(GameDto game, MultipartHttpServletRequest multipart) throws Exception;
    GameDto selectGameDetail(int gameIdx) throws Exception;

    List<ReviewDto> reviewList(int reviewGameIdx) throws Exception;

    void insertReview(int reviewGameIdx, String reviewUserId, String reviewContents, int reviewRating) throws Exception;

    List<GameDto> limitGame() throws Exception;
}
