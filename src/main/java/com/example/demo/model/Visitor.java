package com.example.demo.model;

import jakarta.persistence.*;

public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;

    public long getId(){
        return id;
            }
}