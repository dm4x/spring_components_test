package com.dm4x.components.errorHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "No such Version")
public class VersionNotFoundException extends RuntimeException {
}
