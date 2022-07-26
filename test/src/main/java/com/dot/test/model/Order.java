/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Entity
@Data
@Table(name = "user")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "package_weight", nullable = false)
    private Integer packageWeight;

    @Column(nullable = false)
    private Integer cost;

    @Column(name = "status_code")
    private String statusCode;

    @Column(nullable = false)
    private String courier;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "recipient_number")
    private String recipient_number;

    @Column(name = "created_at", nullable = false)
    private Long createdAt = Instant.now().toEpochMilli();
}
