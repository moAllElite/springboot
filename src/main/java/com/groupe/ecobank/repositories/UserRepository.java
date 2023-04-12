package com.groupe.ecobank.repositories;


import com.groupe.ecobank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select  u  from User  u where u.email=:email")
    Optional<User> findByEmail(String  email);
}
