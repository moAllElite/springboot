package com.groupe.ecobank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address extends  AbstractEntity{
    private String  street;
    private int houseNumber;
    private  int    zipCode;

    private  String city;

    private String country;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
