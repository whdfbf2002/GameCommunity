package com.bitc.springproject.controller;

import com.bitc.springproject.dto.BoardDto;
import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.UserDto;
import com.bitc.springproject.service.BoardService;
import com.bitc.springproject.service.CategoryService;
import com.bitc.springproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/home");

        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        mv.addObject("user", user);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        // 5개 제한 게시판
        List<BoardDto> boardList = boardService.limitBoard();
        mv.addObject("boardList", boardList);

        // 5개 제한 공지사항
        List<BoardDto> noticeList = boardService.limitNotice();
        mv.addObject("noticeList", noticeList);

        List<GameDto> limitGame = gameService.limitGame();
        mv.addObject("limitGame", limitGame);

        return mv;
    }
}
