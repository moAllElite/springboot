package com.groupe.ecobank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "_user")
public class User extends  AbstractEntity{

    @Column(length = 50,nullable = false)
    private String firstName;
    @Column(length = 50,nullable = false)
    private String lastName;
    @Column(length = 100,nullable = false)
    private String email;
    @Column(length = 100,nullable = false)
    private  String password;
    @Column
    private boolean  active;
    @OneToOne
    private  Address address;
    @OneToOne
    private Role role;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;


}
