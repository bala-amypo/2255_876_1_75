package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class ScoreAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "riskrule_id", nullable = false)
    private RiskRule appliedRule;

    private int scoreChange;

    @Column(nullable = false)
    private String reason;

    private LocalDateTime loggedAt;

    public ScoreAuditLog() {
    }

    public ScoreAuditLog(Visitor visitor, RiskRule appliedRule, int scoreChange, String reason) {
        this.visitor = visitor;
        this.appliedRule = appliedRule;
        this.scoreChange = scoreChange;
        this.reason = reason;
    }

    @PrePersist
    protected void prePersist() {
        if (visitor == null) {
            throw new RuntimeException("visitor required");
        }
        if (appliedRule == null) {
            throw new RuntimeException("appliedRule required");
        }
        if (scoreChange == 0) {
            throw new RuntimeException("scoreChange cannot be 0");
        }
        if (reason == null || reason.isBlank()) {
            throw new RuntimeException("reason required");
        }
        this.loggedAt = LocalDateTime.now();
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
}
