package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.Address;
import com.groupe.ecobank.model.User;
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
    private String  street;
    private int houseNumber;
    private  int    zipCode;
    private  String city;
    private String country;
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
