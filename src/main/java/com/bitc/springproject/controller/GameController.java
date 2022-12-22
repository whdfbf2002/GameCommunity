package com.bitc.springproject.controller;


import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.service.CategoryService;
import com.bitc.springproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/game", method= RequestMethod.GET)
    public ModelAndView gameList() throws Exception {
        ModelAndView mv = new ModelAndView("game/gameList");

        List<GameDto> dataList = gameService.selectGameList();
        mv.addObject("dataList", dataList);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

    @RequestMapping("/game/write")
    public String boardWrite() throws Exception {
        return "game/gameWrite";
    }

    @RequestMapping(value = "/game/write", method= RequestMethod.GET)
    public ModelAndView writeGameCate() throws Exception {
        ModelAndView mv = new ModelAndView("/game/gameWrite");

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }


    @RequestMapping("/game/insertGame")
    public String insertGame(GameDto game, MultipartHttpServletRequest multipart) throws Exception {
        gameService.insertGame(game, multipart);

        return "redirect:/game";
    }

    @RequestMapping(value = "/game/{gameIdx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("gameIdx") int gameIdx) throws Exception {
        ModelAndView mv = new ModelAndView("game/gameDetail");

        GameDto game = gameService.selectGameDetail(gameIdx);
        mv.addObject("game", game);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

}
