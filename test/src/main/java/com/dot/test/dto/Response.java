/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.dto;

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
public class Response<T> {

    private boolean ok;
    private String statusCode;
    private String statusMessage;
    private T payload;

    public static Response dataNotFound() {
        return new Response(false, "404", "Data Not Found", null);
    }

    public static Response dataNotFound(String message) {
        return new Response(false, "404", message, null);
    }

    public static Response badRequest() {
        return new Response(false, "400", "Bad Request", null);
    }

    public static Response badRequest(String message) {
        return new Response(false, "400", message, null);
    }

    public static Response internalServerError() {
        return new Response(false, "500", "Internal Server Error", null);
    }
}
