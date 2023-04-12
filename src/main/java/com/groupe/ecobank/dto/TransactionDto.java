package com.groupe.ecobank.dto;

import com.groupe.ecobank.models.Transaction;
import com.groupe.ecobank.models.TransactionType;
import com.groupe.ecobank.models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate transactionDate;
    // on transforme un objet dto en entity
    public static  TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .transactionDate(transaction.getTransactionDate())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getId())
                .build();
    }
    //on transforme un objet entity en objet dto
    public static  Transaction toEntity(TransactionDto transaction){
        return Transaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .transactionDate(transaction.getTransactionDate())
                .destinationIban(transaction.getDestinationIban())
                .user(
                        User.builder()
                                .id(transaction.getId())
                                .build()
                )
                .build();
    }
}
