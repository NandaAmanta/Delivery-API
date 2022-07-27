/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

/**
 *
 * @author ASUS
 */
public class ProvinceNotFoundException extends RuntimeException {

    public ProvinceNotFoundException() {
    }

    public ProvinceNotFoundException(String message) {
        super(message);
    }

    public ProvinceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProvinceNotFoundException(Throwable cause) {
        super(cause);
    }

}
