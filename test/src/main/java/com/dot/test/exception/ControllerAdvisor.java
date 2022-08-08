/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

import com.dot.test.dto.ResponseBody;
import io.jsonwebtoken.SignatureException;
import java.util.concurrent.TimeoutException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
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
        return new ResponseEntity<>(ResponseBody.badRequest("Invalid Data Request, please check your data."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourierNotFoundException.class)
    public ResponseEntity<ResponseBody> handleCourierNotFoundException() {
        return new ResponseEntity<>(ResponseBody.dataNotFound("Courier not found. currently we only have  pos, tiki, dan jne as our courier."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AuthenticationException.class,SignatureException.class})
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

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ResponseBody.badRequest("Invalid Data Request, please check your data."), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ResponseBody.methodNotAllowed("Request method not supported"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ResponseBody.dataNotFound("Resource Not found"), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ResponseBody.badRequest("Invalid Data Request, please check your data."), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBody> handleUnhandleException(Exception ex) {
        return new ResponseEntity<>(ResponseBody.internalServerError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
