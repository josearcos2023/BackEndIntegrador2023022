package com.integrador.backend2.service;

import com.integrador.backend2.domain.LoginDTO;
import com.integrador.backend2.domain.UserDTO;
import com.integrador.backend2.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);
}
