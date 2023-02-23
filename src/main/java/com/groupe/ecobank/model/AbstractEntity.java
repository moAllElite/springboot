package com.groupe.ecobank.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@SuperBuilder
@Data
@NoArgsConstructor
public class AbstractEntity {
    @Id
    @GeneratedValue
    private  int id;
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false,
            name = "createDate"
    )
    private LocalDate creationDate;
    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private LocalDate lastModifiedDate;
}
