package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class VisitLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String purpose;
    private String location;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Visitor getVisitor() {
        return Visitor;
    }
    public void setVisitor(Visitor visitor) {
        Visitor = visitor;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public VisitLog(long id, Visitor visitor, LocalDateTime entryTime, LocalDateTime exitTime, String purpose, String location) {
        this.id = id;
        Visitor = visitor;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.purpose = purpose;
        this.location = location;
    }
    public VisitLog() {
    }
}
