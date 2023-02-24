package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.User;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    @NotNull(message = "le champs  prenom ne doit pas être vide")
    @NotEmpty(message = "le champs  prenom de passe ne doit pas être vide")
    @NotBlank(message = "le champs de prenom ne doit pas être vide")
    private String firstName;
    @NotNull(message = "le champs  nom ne doit pas être vide")
    @NotEmpty(message = "le champs  nom de passe ne doit pas être vide")
    @NotBlank(message = "le champs de nom ne doit pas être vide")
    private String lastName;
    @NotNull(message = "le champs  email ne doit pas être vide")
    @NotEmpty(message = "le champs  email ne doit pas être vide")
    @NotBlank(message = "le champs  email ne doit pas être vide")
    @Email
    private String email;
    @NotNull(message = "le champs  mot de passe ne doit pas être vide")
    @NotEmpty(message = "le champs  mot de passe ne doit pas être vide")
    @NotBlank(message = "le champs  mot de passe ne doit pas être vide")
    @Size(min = 8,max = 16,message = "Erreur le mot de passe doit être au moins de 8 caractères")
    private  String password;
    //on transforme un objet dto en objet entity
    public  static UserDto fromEntity(User user){
    return UserDto.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .password(user.getPassword())
            .build();
    }
    //on transforme un objet entity en objet dto
    public static User toEntity(UserDto user){
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
