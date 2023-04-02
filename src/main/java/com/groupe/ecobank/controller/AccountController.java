package com.groupe.ecobank.controller;

import com.groupe.ecobank.dto.AccountDto;
import com.groupe.ecobank.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final IAccountService service;
    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody AccountDto accountDto
            ){
        return ResponseEntity.ok(service.save(accountDto));
    }

    @GetMapping("/")
    public  ResponseEntity<List<AccountDto>> findAll(){return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findById(
            @PathVariable("account-id") Integer accountId
    ){
        return ResponseEntity.ok(service.findById(accountId));
    }
    @DeleteMapping("/{account-id}")
    public ResponseEntity<AccountDto> delete(
            @PathVariable("account-id") Integer accountId
    ){
        service.delete(accountId);
        return ResponseEntity.accepted().build();
    }
}
