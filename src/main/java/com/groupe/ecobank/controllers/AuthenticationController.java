package com.groupe.ecobank.controllers;

import com.groupe.ecobank.config.JwtUtils;
import com.groupe.ecobank.dto.AuthenticationRequest;
import com.groupe.ecobank.dto.AuthenticationResponse;
import com.groupe.ecobank.dto.UserDto;
import com.groupe.ecobank.repositories.UserRepository;
import com.groupe.ecobank.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    //injection de dépendances
    private final IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse>register(
            @RequestBody UserDto user)
    {
        return ResponseEntity.ok(userService.register(user));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        /***
         * pour l'authentification du user
         */
         return  ResponseEntity.ok(userService.authenticate(request));    }
}
