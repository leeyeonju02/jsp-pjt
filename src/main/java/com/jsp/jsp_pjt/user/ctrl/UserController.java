package com.jsp.jsp_pjt.user.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.jsp_pjt.user.domain.UserRequestDTO;
import com.jsp.jsp_pjt.user.domain.UserResponseDTO;
import com.jsp.jsp_pjt.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;



@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login.multicampus")
    public String login(UserRequestDTO params, HttpSession session, RedirectAttributes attributes) {

        System.out.println("debug >>> UserController user endpoint : /user/login.multicampus");
        System.out.println("debug >>> params : "+ params);
        UserResponseDTO result = userService.login(params);
        System.out.println("debug >>> result : "+result);
        
        if( result != null){
            //암호화 이후 로그인 처리 구현부
            //비밀번호 일치 여부를 matches() 메서드를 이용해서 확인
            String userPwd    = params.getPwd();
            String encoderPwd = result.getPwd();
            
            if(passwordEncoder.matches(userPwd, encoderPwd)){
                System.out.println("debug >>> matches() true ");
                result.setPwd("");
                // jsp 상태관리(트래킹 매커니즘) - request(포워드 되는 페이지까지만), session(모든 페이지)
                session.setAttribute("loginUser", result);
                return "landing";
            } else{
                attributes.addFlashAttribute("loginFail","비밀번호가 일치하지 않습니다");
                return "redirect:/";
            }
        } else{
            attributes.addFlashAttribute("loginFail","아이디 또는 비밀번호가 일치하지 않습니다");
            return "redirect:/";
        }
    }

    @GetMapping("/logout.multicampus")
    public String logout(HttpSession session) {
        System.out.println("debug >>> UserController user endpoint : /user/logout.multicampus");
        session.invalidate();
        return "redirect:/";
    }
    
    @GetMapping("/join.multicampus")
    public String joinForm() {
        System.out.println("debug >>> UserController user endpoint get : /user/join.multicampus");
        return "join";
    }
    
   @PostMapping("/join.multicampus")
public String join(@Valid UserRequestDTO params, BindingResult bindResult, Model model, @RequestParam("file") MultipartFile file) {
    System.out.println("debug >>> UserController user endpoint post : /user/join.multicampus");
    if (bindResult.hasErrors()) {
        System.out.println("debug >>> valid has errors");
        List<ObjectError> list = bindResult.getAllErrors();
        Map<String, String> map = new HashMap<>();
        for (ObjectError error : list) {
            FieldError field = (FieldError) error;
            String key = field.getField();
            String msg = field.getDefaultMessage();
            System.out.println(key + "\t" + msg);
            map.put(key, msg);
        }
        model.addAttribute("errMap", map);
        return "join";
    } else {
        System.out.println("debug >>> 유효성 검증 통과");
        // 비밀번호 암호화
        System.out.println("debug >>> 암호화 객체 = " + passwordEncoder);
        System.out.println("debug >>> params = " + params);
        String encoderPwd = passwordEncoder.encode(params.getPwd());
        System.out.println("encoderPwd = " + encoderPwd);
        params.setPwd(encoderPwd);
        userService.join(params, file);

        return "redirect:/";
    }
}

    
}