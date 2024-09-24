package com.jsp.jsp_pjt.board.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.jsp_pjt.board.domain.BoardResponseDTO;
import com.jsp.jsp_pjt.board.domain.UserBoardResponseDTO;
import com.jsp.jsp_pjt.board.service.BoardService;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    @GetMapping("/list.multicampus")
    public String list(Model model) {
        System.out.println("debug >>> BoardController user endpoint : /board/list.multicampus");
        List<BoardResponseDTO> result = boardService.list();
        System.out.println("debug >>> result size = "+ result.size());
        model.addAttribute("boards", result);
        return "listPage";
    }

    @GetMapping("/myPage.multicampus")
    public String getMethodName(@RequestParam("id") String id, Model model) {
        System.out.println("debug >>. BoardController user endpoint : /board/myPage.multicampus");
        System.out.println("params = " + id);
        
        List<UserBoardResponseDTO> result = boardService.history(id);
        System.out.println("debug >>> result size = " + result.size());
        
        model.addAttribute("boards", result);
        return "listPage";
    }
    
    
}