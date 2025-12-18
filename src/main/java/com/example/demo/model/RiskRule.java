package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Column(nullable = false)
    private String ruleType;

    private int threshold;

    private int scoreImpact;

    private LocalDateTime createdAt;

    public RiskRule() {
    }

    public RiskRule(String ruleName, String ruleType, int threshold, int scoreImpact) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.threshold = threshold;
        this.scoreImpact = scoreImpact;
    }

    @PrePersist
    protected void prePersist() {
        if (ruleName == null || ruleName.isBlank()) {
            throw new RuntimeException("ruleName required");
        }
        if (ruleType == null || ruleType.isBlank()) {
            throw new RuntimeException("ruleType required");
        }
        if (threshold <= 0) {
            throw new RuntimeException("threshold must be greater than 0");
        }
        if (scoreImpact == 0) {
            throw new RuntimeException("scoreImpact cannot be 0");
        }
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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
}
