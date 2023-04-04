package com.groupe.ecobank.handlers;

import com.groupe.ecobank.exceptions.ObjectValidationException;
import com.groupe.ecobank.exceptions.OperationNonPermittedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRespresentation> handleException(ObjectValidationException exception){
        //on envoie une réponse au user
         ExceptionRespresentation respresentation=ExceptionRespresentation.builder()
                 .erroMessage("L'objet non valide a été soulevé")
                 .errorSource(exception.getViolationSource())
                 .validationErrors(exception.getViolation())
                 .build();
         return  ResponseEntity.status(HttpStatus.BAD_REQUEST)//code 400
                 .body(respresentation);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRespresentation> handleException(EntityNotFoundException exception){
        ExceptionRespresentation respresentation=ExceptionRespresentation.builder()
                .erroMessage(exception.getMessage())
                .build();
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)//code 404
                .body(respresentation);
    }
    @ExceptionHandler(OperationNonPermittedException.class)
    public ResponseEntity<ExceptionRespresentation> handleException(OperationNonPermittedException  exception){
        ExceptionRespresentation respresentation=ExceptionRespresentation.builder()
                .erroMessage(exception.getErrorMsg())
                .build();
        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)//code 406
                .body(respresentation);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionRespresentation> handleException( ){
        ExceptionRespresentation respresentation=ExceptionRespresentation
                .builder()
                .erroMessage("L'email  fourni  a déjà été attribut à un utilisateur ")
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(respresentation);
    }
}
