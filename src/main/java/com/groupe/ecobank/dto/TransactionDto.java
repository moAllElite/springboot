package com.groupe.ecobank.dto;

import com.groupe.ecobank.model.Transaction;
import com.groupe.ecobank.model.TransactionType;
import com.groupe.ecobank.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Integer id;

    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String destinationIban;
    private Integer userId;
    // on transforme un objet dto en entity
    private  static  TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getId())
                .build();
    }
    //on transforme un objet entity en objet dto
    private  static  Transaction toEntity(TransactionDto transaction){
        return Transaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .user(
                        User.builder()
                                .id(transaction.getId())
                                .build()
                )
                .build();
    }
}
