package com.kiselyov.components.errorHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No such Component")
public class ComponentNotFoundException extends RuntimeException {

}
