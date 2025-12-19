package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.*;
import java.util.*;
import com.example.demo.util.RiskLevelUtils;


@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        Optional<RiskScore> existing = riskScoreRepository.findByVisitorId(visitorId);
        if (existing.isPresent()) {
            return existing.get();
        }

        int scoreValue = 50;

        RiskScore score = new RiskScore();
        score.setVisitor(visitor);
        score.setTotalScore(scoreValue);
        score.setRiskLevel(RiskLevelUtils.determineRiskLevel(scoreValue));
        score.setRiskRule(appliedRule);
        
        return riskScoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId).orElse(null);
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
