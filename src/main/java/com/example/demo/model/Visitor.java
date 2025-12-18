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
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String idProof;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (fullName == null || fullName.isBlank()) {
            throw new RuntimeException("fullName required");
        }
        if (phone == null || phone.isBlank()) {
            throw new RuntimeException("phone required");
        }
        if (idProof == null || idProof.isBlank()) {
            throw new RuntimeException("idProof required");
        }
        this.createdAt = LocalDateTime.now();
    }

}
