package com.groupe.ecobank.repositories;

import com.groupe.ecobank.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
   List<Contact> findAllByUserId(Integer userid);
}
