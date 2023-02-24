package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
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
