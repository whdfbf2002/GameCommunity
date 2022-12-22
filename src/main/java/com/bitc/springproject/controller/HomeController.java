package com.bitc.springproject.controller;

import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.GameDto;
import com.bitc.springproject.dto.UserDto;
import com.bitc.springproject.service.CategoryService;
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

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("/home");

        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        mv.addObject("user", user);

        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }
}
