package com.groupe.ecobank.controllers;

import com.groupe.ecobank.dto.TransactionDto;
import com.groupe.ecobank.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final ITransactionService service;
    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestParam TransactionDto transactionDto
            )
    {
        return ResponseEntity.ok(service.save(transactionDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>>findAll(){return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{transaction-id}")
    public ResponseEntity<TransactionDto> findById(
            @PathVariable("transaction-id") Integer transactionId
    ){
        return ResponseEntity.ok(service.findById(transactionId));
    }
    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<TransactionDto>> findAllByIdUser(
            @PathVariable("user-id") Integer    userId
    ){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }
    @DeleteMapping("/{transaction-id}")
    public  ResponseEntity<TransactionDto> delete(
            @PathVariable("transaction-id") Integer transactionId
    ){
        service.delete(transactionId);
        return  ResponseEntity.accepted().build();
    }
}
