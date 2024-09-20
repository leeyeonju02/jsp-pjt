package com.jsp.jsp_pjt.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.jsp.jsp_pjt.user.domain.UserRequestDTO;
import com.jsp.jsp_pjt.user.domain.UserResponseDTO;
import com.jsp.jsp_pjt.user.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;


//user endpoint : http//localhost:7777/user
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService; //객체 생성 : 의존성 주입

     //http//localhost:7777/user/login.multicompus
    @PostMapping("/login.multicampus")
    public String login(UserRequestDTO params, HttpSession session) {
        System.out.println("debug >>> IndexController user endpoint : /user/login.multicompus");
        System.out.println("debug >>> params : " + params);
        UserResponseDTO result = userService.login(params);
        System.out.println("debug >>> result : " + result);

        if(result != null) {
            //jsp 상태관리(트래킹 매커니즘) - request (포워드되는 페이지까지만), session(모든 페이지)
            session.setAttribute("loginUser", result);
            return "redirect:/board/list.multicampus";
        } else {
            return "redirect:/";
        }
        
        
        
    }
    
}
