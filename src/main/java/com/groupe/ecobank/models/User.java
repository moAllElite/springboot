package com.groupe.ecobank.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "_user")
public class User extends  AbstractEntity implements UserDetails{
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
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


    /**
     * @return role.getName()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }

    /**
     * @return email
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * @return  true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return active
     */
    @Override
    public boolean isEnabled() {
        return active;
    }
}
