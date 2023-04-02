package com.groupe.ecobank.controller;

import com.groupe.ecobank.dto.ContactDto;
import com.groupe.ecobank.service.IContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {
    private final IContactService service;
    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody ContactDto contactDto
            )
    {
        return ResponseEntity.ok(service.save(contactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){return  ResponseEntity.ok(service.findAll());}

    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<ContactDto>> findAllByIdUser(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("/{coontact-id}")
    public ResponseEntity<ContactDto> findById(
            @PathVariable("contact-id") Integer contactId
            )
    {
        return ResponseEntity.ok(service.findById(contactId));
    }
    @DeleteMapping("/{conctact-id}")
    public ResponseEntity<ContactDto> delete(
            @PathVariable("conctat-id") Integer conctactId
    ){
        service.delete(conctactId);
        return ResponseEntity.accepted().build();
    }
}
