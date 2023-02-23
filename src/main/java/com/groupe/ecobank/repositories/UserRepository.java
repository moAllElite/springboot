package com.groupe.ecobank.repositories;


import com.groupe.ecobank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
