package com.groupe.ecobank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Transaction extends  AbstractEntity{
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private  TransactionType type;
    private String destinationIban;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
