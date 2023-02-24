package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.Account;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AccountDto {
    private Integer id;
    private String iban;

    private UserDto user;
    //on transforme un objet dto en entity
    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.fromEntity(account.getUser()))
                .build();
    }
    //on transforme un objet entity en objet dto
    public static Account toEntity(AccountDto account){
        return  Account.builder()
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUser()))
                .build();
    }
}
