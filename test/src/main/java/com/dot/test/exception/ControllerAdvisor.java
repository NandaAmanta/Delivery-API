/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

import com.dot.test.dto.ResponseBody;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author ASUS
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class, OrderNotFoundException.class})
    public ResponseEntity<ResponseBody> handleUserNotFoundException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.dataNotFound(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({PropertyValueException.class, HttpClientErrorException.BadRequest.class, IllegalArgumentException.class})
    public ResponseEntity<ResponseBody> handlePropertyValue() {
        return new ResponseEntity<>(ResponseBody.badRequest("Invalid Bad Request, please check your data."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ResponseBody> handleAuthException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.unAuthenticated(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody> handleUnhandleException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.internalServerError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
