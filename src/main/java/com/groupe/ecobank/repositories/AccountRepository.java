package com.groupe.ecobank.repositories;

import com.groupe.ecobank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
