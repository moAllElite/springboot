package com.groupe.ecobank.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;

}
