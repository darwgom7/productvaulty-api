package com.darwgom.productvaultyapi.application.usecases;

import com.darwgom.productvaultyapi.application.dto.UserDTO;
import com.darwgom.productvaultyapi.application.dto.UserInputDTO;
import com.darwgom.productvaultyapi.application.dto.TokenDTO;
import com.darwgom.productvaultyapi.application.dto.LoginDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface IUserUseCase {
    UserDTO registerUser(UserInputDTO userInputDTO);
    TokenDTO loginUser(LoginDTO loginDTO);
    MessageDTO deleteUser(Long userId);
    UserDTO getCurrentUser(String jwt);
    MessageDTO logoutUser(String jwt);
}
