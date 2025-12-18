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
    public void setId(long id){
        this.id = id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getEmail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}