package com.groupe.ecobank.repositories;

import com.groupe.ecobank.model.Transaction;
import com.groupe.ecobank.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query("from  Transaction   where  amount=:amount")
    List<Transaction> findByAmountContaining(BigDecimal amount);
    //select * from transaction as t inner join user as u where u.id=a=t.id_user
    @Query("from  Transaction t inner  join User  u where  u.id=t.user.id")
    List<Transaction> findTransactionByIdAAndUser(Integer id);

    List<Transaction> findAllByUserId(Integer userId);
    @Query("select sum (t.amount) from  Transaction  t where t.user.id=:userId")
    BigDecimal findAccountBalance(Integer userId);
    @Query("select max(abs(t.amount)) as amount from Transaction  t where t.user.id=:userId and  t.type=:transactionType")
    BigDecimal findHighestAmountByTransaction(Integer userId, TransactionType transfertType);
    @Query("select  t.creationDate ,sum (t.amount)  from  Transaction t where t.user.id=:id and t.creationDate between  :start and :end group by t.creationDate")
    Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);
}
