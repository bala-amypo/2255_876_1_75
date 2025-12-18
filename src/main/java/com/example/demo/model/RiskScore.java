package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class RiskScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    private int totalScore;
    private String riskLevel;
    private LocalDateTime evaluatedAt;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

    public RiskScore(long id, Visitor visitor, int totalScore, String riskLevel, LocalDateTime evaluatedAt) {
        this.id = id;
        this.visitor = visitor;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.evaluatedAt = evaluatedAt;
    }

    public RiskScore() {
    }
}
