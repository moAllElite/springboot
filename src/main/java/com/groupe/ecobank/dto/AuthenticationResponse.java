package com.groupe.ecobank.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;

}
