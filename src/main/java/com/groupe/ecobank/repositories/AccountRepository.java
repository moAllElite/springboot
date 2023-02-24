package com.groupe.ecobank.repositories;

import com.groupe.ecobank.model.Account;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    //select * from account like iban="de55"
    @Query("from  Account  where iban=:iban")
    Account searchByIbanContainsIgnoreCase(String iban);
    @Query("from  Account a inner join  User u where u.id=a.user.id and a.creationDate=:creationDate ")
    Account searchByCreationDate(Date creationDate );
    @Query(value = "select  * from account where  id=:id group by id",nativeQuery = true)
    Account searchByIdNative(String id);
}
