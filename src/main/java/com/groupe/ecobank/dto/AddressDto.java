package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.Address;
import com.groupe.ecobank.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto {
    private Integer id;
    @NotNull
    @NotEmpty
    private String  street;
    @NotNull
    @NotEmpty
    private int houseNumber;
    @NotNull(message = "le champs  zip code ne doit pas être vide")
    @NotEmpty(message = "le champs  zip code de passe ne doit pas être vide")
    @NotBlank(message = "le champs de zip code ne doit pas être vide")
    @Positive(message = "le champs de zip code ne doit pas être vide")
    private  int    zipCode;
    private  String city;
    @NotNull(message = "le champs  country ne doit pas être vide")
    @NotEmpty(message = "le champs  country  de passe ne doit pas être vide")
    @NotBlank(message = "le champs de country  code ne doit pas être vide")
    private String country;
    @NotNull
    @NotEmpty
    @Positive
    private Integer userId;

    //on transforme un objet entity en objet dto
    private static AddressDto fromEntity(Address address){
        return  AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .userId(address.getUser().getId())
                .build();
    }
    // on transforme un objet dto en entity
    private static Address toEntity(AddressDto address){
        return  Address.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .user(
                        User.builder()
                                .id(address.getUserId())
                                .build()
                )
                .build();
    }
}
