package com.groupe.ecobank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address extends  AbstractEntity{
    @Column(nullable = false,length = 80)
    private String  street;

    private int houseNumber;
    private  int    zipCode;
    @Column(nullable = false,length = 80)
    private  String city;
    @Column(nullable = false,length = 80)
    private String country;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
