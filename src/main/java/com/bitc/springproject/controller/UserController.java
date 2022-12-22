package com.bitc.springproject.controller;

import com.bitc.springproject.dto.CategoryDto;
import com.bitc.springproject.dto.UserDto;
import com.bitc.springproject.mapper.UserMapper;
import com.bitc.springproject.service.CategoryService;
import com.bitc.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

//    회원 가입 화면
    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public ModelAndView singUp() throws Exception {
        ModelAndView mv = new ModelAndView("user/signup");

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }

//    회원 데이터 추가
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String insertUser(UserDto user) throws Exception {
        userService.insertUser(user);
        return "redirect:/";
    }

//    id 중복 체크
    @ResponseBody
    @RequestMapping(value = "/signup/idCheck", method = RequestMethod.GET)
    public int userIdCheck(UserDto user) throws Exception{
        int result = userService.userIdCheck(user);
        return result;
    }

//    로그인 화면
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView mv = new ModelAndView("user/login");

        // 사이드바 카테고리
        List<CategoryDto> categoryList = categoryService.categoryList();
        mv.addObject( "categoryList", categoryList);

        return mv;
    }


//    로그인 처리
    @ResponseBody
    @RequestMapping(value = "/login/check", method= RequestMethod.POST)
    public Object userLogin(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        UserDto userDto = userService.loginCheck(userId, userPw);

        if(session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }

        session.setAttribute("user", userDto);

        if (userDto == null) {return 0;}
        else {return userDto;}
    }

//     로그아웃
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/logout";
    }

//     프로필(회원정보) 화면
    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView profile() throws Exception {

        ModelAndView mv = new ModelAndView("user/profile");
        return mv;
    }
//dsadsa
//     회원정보 수정
    @RequestMapping("/updateUser")
    public String updateUser(UserDto user) throws Exception {
//        userMapper.updateUser(user);
        return "redirect:/profile";
    }

}
