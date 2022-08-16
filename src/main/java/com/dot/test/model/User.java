/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Entity
@Data
@Table(name = "user_table")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status_code")
    private String statusCode = "200";

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Boolean lock = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    @Column(name = "created_at")
    private Long createdAt = Instant.now().toEpochMilli();

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
