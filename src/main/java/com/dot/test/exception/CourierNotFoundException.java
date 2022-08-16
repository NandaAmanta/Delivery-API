/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

/**
 *
 * @author ASUS
 */
public class CourierNotFoundException extends RuntimeException {

    public CourierNotFoundException() {
    }

    public CourierNotFoundException(String message) {
        super(message);
    }

    public CourierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourierNotFoundException(Throwable cause) {
        super(cause);
    }

}
