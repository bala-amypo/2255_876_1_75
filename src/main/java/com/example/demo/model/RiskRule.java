package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ruleName;
    private String ruleType;
    private int threshold;
    private int scoreImpact;
    private LocalDateTime createdAt;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleType() {
        return ruleType;
    }
    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }
    public int getThreshold() {
        return threshold;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public int getScoreImpact() {
        return scoreImpact;
    }
    public void setScoreImpact(int scoreImpact) {
        this.scoreImpact = scoreImpact;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public RiskRule(long id, String ruleName, String ruleType, int threshold, int scoreImpact,
            LocalDateTime createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
        this.createdAt = createdAt;
    }
    public RiskRule() {
    }
}
