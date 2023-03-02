package com.groupe.ecobank.repositories;

import com.groupe.ecobank.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
