package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.Contact;
import com.groupe.ecobank.model.User;
import jakarta.validation.constraints.NotBlank;
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
public class ContactDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String iban;
    private  Integer userId;

    private static ContactDto   fromEntity(Contact contact){
        return ContactDto.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .iban(contact.getIban())
                .userId(contact.getUser().getId())
                .build();
    }
    private static Contact toEntity(ContactDto contact){
        return Contact.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .iban(contact.getIban())
                .user(
                        User.builder()
                                .id(contact.getUserId())
                                .build()
                )
                .build();
    }
}
