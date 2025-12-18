package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String location;

    public VisitLog() {
    }

    public VisitLog(Visitor visitor, LocalDateTime exitTime, String purpose, String location) {
        this.visitor = visitor;
        this.exitTime = exitTime;
        this.purpose = purpose;
        this.location = location;
    }

    @PrePersist
    public void prePersist() {
        this.entryTime = LocalDateTime.now();

        if (purpose == null || purpose.isBlank()) {
            throw new RuntimeException("purpose required");
        }
        if (location == null || location.isBlank()) {
            throw new RuntimeException("location required");
        }
        if (exitTime != null && exitTime.isBefore(entryTime)) {
            throw new RuntimeException("exitTime must be after entryTime");
        }
    }

    public Long getId() {
        return id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
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
}
