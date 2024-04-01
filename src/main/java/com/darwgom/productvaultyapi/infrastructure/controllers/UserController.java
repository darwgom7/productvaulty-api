package com.darwgom.productvaultyapi.infrastructure.controllers;

import com.darwgom.productvaultyapi.application.dto.UserInputDTO;
import com.darwgom.productvaultyapi.application.dto.UserDTO;
import com.darwgom.productvaultyapi.application.dto.TokenDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.dto.LoginDTO;
import com.darwgom.productvaultyapi.application.usecases.IUserUseCase;
import com.darwgom.productvaultyapi.infrastructure.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = {"*"})
@RequestMapping("api/users")
@RestController
public class UserController {
    @Autowired
    private IUserUseCase userUseCase;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserInputDTO userInputDTO) {
        UserDTO userDTO = userUseCase.registerUser(userInputDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        TokenDTO tokenDTO = userUseCase.loginUser(loginDTO);
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageDTO> deleteUser(@PathVariable Long userId) {
        MessageDTO messageDTO = userUseCase.deleteUser(userId);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(HttpServletRequest request) {
        String jwt = jwtTokenProvider.extractJwtFromRequest(request);
        UserDTO userDTO = userUseCase.getCurrentUser(jwt);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<MessageDTO> logoutUser(HttpServletRequest request) {
        String jwt = jwtTokenProvider.extractJwtFromRequest(request);
        MessageDTO messageDTO = userUseCase.logoutUser(jwt);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }
}


