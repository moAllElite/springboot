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
public class Account    extends  AbstractEntity {

    private String iban;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User  user;
}
