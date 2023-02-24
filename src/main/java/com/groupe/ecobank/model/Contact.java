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
public class Contact extends  AbstractEntity{
    private String firstName;
    private String lastName;
    private String iban;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
