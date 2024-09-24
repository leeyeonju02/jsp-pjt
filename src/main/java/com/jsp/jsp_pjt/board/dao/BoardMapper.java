package com.jsp.jsp_pjt.board.dao;


import org.apache.ibatis.annotations.Mapper;

import com.jsp.jsp_pjt.board.domain.BoardResponseDTO;
import com.jsp.jsp_pjt.board.domain.UserBoardResponseDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardResponseDTO> listRow();
    public List<UserBoardResponseDTO> myHistoryRow(String id);
}
