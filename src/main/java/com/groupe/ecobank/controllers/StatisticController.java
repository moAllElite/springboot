package com.groupe.ecobank.controllers;

import com.groupe.ecobank.dto.TransactionSumDetails;
import com.groupe.ecobank.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticController {
    private final StatisticService service;
    @GetMapping("/sum-by-date/{user-id}")
    public ResponseEntity<List<TransactionSumDetails>>findSumTransactionsByDate(
            @PathVariable("user-id")   Integer userId,
            @RequestParam("start-date")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("end-date")@DateTimeFormat(pattern = "yyyy-MM-dd")   LocalDate endDate
     )
    {

        return ResponseEntity.ok(service.findSumTransactionsByDate(startDate,endDate,userId));
    }
    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(
            @PathVariable("user-id") Integer userId
    ){
        return  ResponseEntity.ok(service.getAccountBalance(userId));
    }
    @GetMapping("/highest-transfert/{user-id}")
    public ResponseEntity<BigDecimal> highestTransfert( @PathVariable("user-id")    Integer userId){
        return ResponseEntity.ok(service.highestTransfert(userId));
    }
    @GetMapping("/highest-deposit/{user-id}")
    public ResponseEntity<BigDecimal> highestDeposit( @PathVariable("user-id")  Integer userId){
        return ResponseEntity.ok(service.highestDeposit(userId));
    }
}
