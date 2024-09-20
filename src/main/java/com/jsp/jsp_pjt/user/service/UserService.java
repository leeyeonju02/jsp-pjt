package com.jsp.jsp_pjt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.jsp_pjt.user.dao.UserMapper;
import com.jsp.jsp_pjt.user.domain.UserRequestDTO;
import com.jsp.jsp_pjt.user.domain.UserResponseDTO;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO login(UserRequestDTO params) {
        System.out.println("debug >>> userService login");
        return userMapper.loginRow(params);
    }
}
