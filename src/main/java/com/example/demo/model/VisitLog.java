package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class VisitLog {
    private long id;
    private ManyToOne Visitor;
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
    public ManyToOne getVisitor() {
        return Visitor;
    }
    public void setVisitor(ManyToOne visitor) {
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
    public VisitLog(long id, ManyToOne visitor, LocalDateTime entryTime, LocalDateTime exitTime, String purpose, String location) {
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
