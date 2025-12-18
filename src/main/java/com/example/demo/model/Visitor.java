package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String fullName;
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String idProof;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (fullName == null || fullName.isBlank()) {
            throw new RuntimeException("fullName required");
        }
        if (phone == null || phone.isBlank()) {
            throw new RuntimeException("phone required");
        }
        if (idProof == null || idProof.isBlank()) {
            throw new RuntimeException("idProof required");
        }
        this.createdAt = LocalDateTime.now();
    }
    
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
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getIdProof(){
        return idProof;
    }
    public void setIdProof(String idProof){
        this.idProof = idProof;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public Visitor(long id, String fullName, String email, String phone, String idProof, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.idProof = idProof;
        this.createdAt = createdAt;
    }
    public Visitor() {
    }
    
}