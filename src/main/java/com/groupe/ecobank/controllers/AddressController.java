package com.groupe.ecobank.controllers;

import com.groupe.ecobank.dto.AddressDto;
import com.groupe.ecobank.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private  final IAddressService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
         @RequestBody AddressDto addressDto
    ){
        return ResponseEntity.ok(service.save(addressDto));
    }
    @GetMapping("/")
    public ResponseEntity <List<AddressDto>> findAll(){
        return  ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{address-id}")
    public ResponseEntity <AddressDto> findById(
            @PathVariable Integer addressId
    ){
        return  ResponseEntity.ok(service.findById(addressId));
    }
    @DeleteMapping("/{address-id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer addressId
    ){
        service.delete(addressId);
        return ResponseEntity.accepted().build();
    }
}
