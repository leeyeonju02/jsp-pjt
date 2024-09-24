package com.jsp.jsp_pjt.board.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.jsp_pjt.board.dao.BoardMapper;
import com.jsp.jsp_pjt.board.domain.BoardResponseDTO;
import com.jsp.jsp_pjt.board.domain.UserBoardResponseDTO;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<BoardResponseDTO> list(){
        System.out.println("debug >>> BoardService list ");
        return boardMapper.listRow();
    }

    public List<UserBoardResponseDTO> history(String id){
        System.out.println("debug >>> BoardService history");
        return boardMapper.myHistoryRow(id);
    }
}
