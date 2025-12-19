package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @PrePersist
    protected void prePersist() {
        if (visitor == null) {
            throw new RuntimeException("visitor required");
        }
        if (appliedRule == null) {
            throw new RuntimeException("appliedRule required");
        }
        if (reason == null || reason.isBlank()) {
            throw new RuntimeException("reason required");
        }
        this.loggedAt = LocalDateTime.now();
    }
}
