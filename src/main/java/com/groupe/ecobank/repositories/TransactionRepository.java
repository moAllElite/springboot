package com.groupe.ecobank.repositories;

import com.groupe.ecobank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query("from  Transaction   where  amount=:amount")
    List<Transaction> findByAmountContaining(BigDecimal amount);
    //select * from transaction as t inner join user as u where u.id=a=t.id_user
    @Query("from  Transaction t inner  join User  u where  u.id=t.user.id")
    List<Transaction> findTransactionByIdAAndUser(Integer id);
}
