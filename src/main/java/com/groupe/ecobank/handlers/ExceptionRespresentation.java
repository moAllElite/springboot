package com.groupe.ecobank.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Set;
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionRespresentation {
    private  String erroMessage;
    private String errorSource;
    private Set<String> validationErrors;
}