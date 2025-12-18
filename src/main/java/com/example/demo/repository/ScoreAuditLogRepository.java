package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ScoreAuditLog;

@Repository
public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog,Long>{

}
