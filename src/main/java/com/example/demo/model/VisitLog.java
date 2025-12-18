package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
