package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class RiskScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;
    @ManyToOne
    @JoinColumn(name = "riskrule_id", nullable = false)
    private RiskRule appliedRule;
    private int scoreChange;
    private String reason;
    private LocalDateTime loggedAt;
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
    public RiskRule getAppliedRule() {
        return appliedRule;
    }
    public void setAppliedRule(RiskRule appliedRule) {
        this.appliedRule = appliedRule;
    }
    public int getScoreChange() {
        return scoreChange;
    }
    public void setScoreChange(int scoreChange) {
        this.scoreChange = scoreChange;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
    public RiskScore(long id, Visitor visitor, RiskRule appliedRule, int scoreChange, String reason, LocalDateTime loggedAt) {
        this.id = id;
        this.visitor = visitor;
        this.appliedRule = appliedRule;
        this.scoreChange = scoreChange;
        this.reason = reason;
        this.loggedAt = loggedAt;
    }
    public RiskScore() {
    }
}
