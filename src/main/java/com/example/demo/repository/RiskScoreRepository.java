package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
    RiskScore findByVisitorId(Long visitorId);
}
