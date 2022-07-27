/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.exception;

/**
 *
 * @author ASUS
 */
public class PartnerApiException extends RuntimeException {

    public PartnerApiException() {
    }

    public PartnerApiException(String message) {
        super(message);
    }

    public PartnerApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartnerApiException(Throwable cause) {
        super(cause);
    }

}
