package com.groupe.ecobank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

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
