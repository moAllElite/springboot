package com.groupe.ecobank.controller;

import com.groupe.ecobank.dto.UserDto;
import com.groupe.ecobank.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/**
 * pour le request mapping convention
 * nom de la ressource au pluriel ex:users
 * readabelaté avec des tirets de 6 ou de camel case
 */
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;

    /**
     * pour enregistrer un user
     * @param userDto
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<Integer>save(
         @RequestBody   UserDto userDto
    ){
        return  ResponseEntity.ok(service.save(userDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return  ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(
          @PathVariable("user-id")  Integer userId
    ){
        return ResponseEntity.ok(service.findById(userId));
    }
    @PatchMapping("/validate/{user-id}")
    public ResponseEntity<Integer> validateAccount(
            @PathVariable("user-id") Integer userId
    ){
        return  ResponseEntity.ok(service.validateAccount(userId));
    }
    @PatchMapping("/invalidate/{user-id}")
    public ResponseEntity<Integer> invalidateAccount(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.invalideAccount(userId));
    }
    @DeleteMapping("/{user-id}")
    public  ResponseEntity<Void> delete(
            @PathVariable("user-id") Integer userId
    ){
       service.delete(userId);
       return ResponseEntity.accepted().build();
    }

}
