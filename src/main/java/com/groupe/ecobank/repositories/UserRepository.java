package com.groupe.ecobank.repositories;


import com.groupe.ecobank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    //select * from _user where firstName="mo";
    List<User> findAllByFirstName(String firstName);
    //select * from _user where firstName like '%Mo%';
    List<User> findAllByFirstNameContaining(String firstName);
    //select * from _user where firstName islike '%mo%';
    List<User> findAllByFirstNameContainingIgnoreCase(String firstName);
    //semect * from user u inner join account a where u.id=a.id_user and a.iban="de45555"
    List<User> findAllByAccount_Iban(String iban);
    //select * from user  where firstName="%mo%" and email="mo@gmail.com"
    User    findByFirstNameContainingIgnoreCaseAndEmail(String firstName ,String email);
    @Query("from User where firstName=:firstName")
    List<User> searchUserByFirstName(String firstName);
}
