/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

import com.dot.test.dto.ResponseBody;
import java.security.ProviderException;
import java.util.concurrent.TimeoutException;
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
        return new ResponseEntity<>(ResponseBody.dataNotFound(ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler({PropertyValueException.class, HttpClientErrorException.BadRequest.class, IllegalArgumentException.class})
    public ResponseEntity<ResponseBody> handlePropertyValue() {
        return new ResponseEntity<>(ResponseBody.badRequest("Invalid Bad Request, please check your data."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ResponseBody> handleAuthException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.unAuthenticated("You're not Authenticated. if you dont have an account, you can create one for you first on /api/auth/signup"), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ProvinceNotFoundException.class})
    public ResponseEntity<ResponseBody> handleProvinceNotFound(Exception ex) {
        return new ResponseEntity<>(ResponseBody.dataNotFound("Data Province Not Found"), HttpStatus.OK);
    }

    @ExceptionHandler({CityNotFoundException.class})
    public ResponseEntity<ResponseBody> handleCityNotFound(Exception ex) {
        return new ResponseEntity<>(ResponseBody.dataNotFound("Data City Not Found"), HttpStatus.OK);
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ResponseBody> handleTimeOutException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.timeOut("Request Time out"), HttpStatus.REQUEST_TIMEOUT);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody> handleUnhandleException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.internalServerError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
