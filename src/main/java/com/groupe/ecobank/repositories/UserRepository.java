package com.groupe.ecobank.repositories;


import com.groupe.ecobank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("from User where firstName=:fn")
    List<User> searchUserByFirstName(@Param("fn") String firstName);
    @Query("from User  where  firstName=':%firstName%'")
    List<User> searchUserByFirstNameContaining(String firstName);
    @Query("from  User u inner join  Account a where  u.id=a.user.id and  a.iban=:iban")
    List<User> searchByIban(String iban);
    @Query(value = "select  * from  _user u inner  join  account a where  u.id=a.id_user and a.iban=:iban GROUP BY  id_use",nativeQuery = true)
    List<User> searchByIbanNative(String iban);
}
