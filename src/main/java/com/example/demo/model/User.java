package com.example.demo.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String email;
    private String password;
    private Set<String> role;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    public Set<String> getRole() {
        return role;
    }
    public void setRole(Set<String> role) {
        this.role = role;
    }
    public User(long id, String email, String password, Set<String> role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User() {
    }
    
}
