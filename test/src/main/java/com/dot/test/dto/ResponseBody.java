/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.dto;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ASUS
 * @param <T>
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseBody<T> {

    private boolean ok;
    private String statusCode;
    private String statusMessage;
    private T payload;

    public static ResponseBody ok(String message) {
        return new ResponseBody(false, "200", message, null);
    }

    public static ResponseBody dataNotFound() {
        return new ResponseBody(false, "404", "Data Not Found", new ArrayList<>());
    }

    public static ResponseBody dataNotFound(String message) {
        return new ResponseBody(false, "404", message, new ArrayList<>());
    }

    public static ResponseBody badRequest() {
        return new ResponseBody(false, "400", "Bad Request", new ArrayList<>());
    }

    public static ResponseBody unAuthenticated(String message) {
        return new ResponseBody(false, "403", message, new ArrayList<>());
    }

    public static ResponseBody badRequest(String message) {
        return new ResponseBody(false, "400", message, new ArrayList<>());
    }

    public static ResponseBody methodNotAllowed(String message) {
        return new ResponseBody(false, "405", message, new ArrayList<>());
    }

    public static ResponseBody internalServerError() {
        return new ResponseBody(false, "500", "Internal Server Error", new ArrayList<>());
    }

    public static ResponseBody internalServerError(String message) {
        return new ResponseBody(false, "500", message, new ArrayList<>());
    }

    public static ResponseBody timeOut(String message) {
        return new ResponseBody(false, "408", message, new ArrayList<>());
    }
}
