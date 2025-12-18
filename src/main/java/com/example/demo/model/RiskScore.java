package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "visitor_id", nullable = false, unique = true)
    private Visitor visitor;

    private int totalScore;

    @Column(nullable = false)
    private String riskLevel;

    private LocalDateTime evaluatedAt;

    public RiskScore() {
    }

    public RiskScore(Visitor visitor, int totalScore, String riskLevel) {
        this.visitor = visitor;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
    }

    @PrePersist
    protected void prePersist() {
        if (visitor == null) {
            throw new RuntimeException("visitor required");
        }
        if (totalScore < 0) {
            throw new RuntimeException("totalScore cannot be negative");
        }
        if (riskLevel == null || riskLevel.isBlank()) {
            throw new RuntimeException("riskLevel required");
        }
        this.evaluatedAt = LocalDateTime.now();
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
}
