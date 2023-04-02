package com.groupe.ecobank.handlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Set;
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ExceptionRespresentation {
    private  String erroMessage;
    private String errorSource;
    private Set<String> validationErrors;
}
