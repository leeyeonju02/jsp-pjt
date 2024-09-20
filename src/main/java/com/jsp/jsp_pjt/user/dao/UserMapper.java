package com.jsp.jsp_pjt.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jsp.jsp_pjt.user.domain.UserRequestDTO;
import com.jsp.jsp_pjt.user.domain.UserResponseDTO;

@Mapper
public interface UserMapper {
    

    public UserResponseDTO loginRow(UserRequestDTO params);
}
