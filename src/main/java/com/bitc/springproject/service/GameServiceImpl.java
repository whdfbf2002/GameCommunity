package com.bitc.springproject.service;

import com.bitc.springproject.common.FileUtils;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.GameFileDto;
import com.bitc.springproject.dto.ReviewDto;
import com.bitc.springproject.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    public GameMapper gameMapper;

    @Autowired
    public FileUtils fileUtils;

    @Override
    public List<GameDto> selectGameList() throws Exception {
        return gameMapper.selectGameList();
    }

    @Override
    public void insertGame(GameDto game, MultipartHttpServletRequest uploadFiles) throws Exception {
        gameMapper.insertGame(game);

        List<GameFileDto> fileList = fileUtils.parseFileInfo(game.getGameIdx(), uploadFiles);

        if(!CollectionUtils.isEmpty(fileList)) gameMapper.insertGameFileList(fileList);

    }

    @Override
    public GameDto selectGameDetail(int gameIdx) throws Exception {
        GameDto game = gameMapper.selectGameDetail(gameIdx);

        return game;
    }

    @Override
    public List<ReviewDto> reviewList(int reviewGameIdx) throws Exception {
        return gameMapper.reviewList(reviewGameIdx);
    }

    @Override
    public void insertReview(int reviewGameIdx, String reviewUserId, String reviewContents, int reviewRating) throws Exception {
        ReviewDto review = new ReviewDto();
        review.setReviewGameIdx(reviewGameIdx);
        review.setReviewUserId(reviewUserId);
        review.setReviewContents(reviewContents);
        review.setReviewRating(reviewRating);

        gameMapper.insertReview(review);
    }

    @Override
    public List<GameDto> limitGame() throws Exception {
        return gameMapper.limitGame();
    }
}
