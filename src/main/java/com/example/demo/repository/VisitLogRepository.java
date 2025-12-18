package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
    List<VisitLog> findByVisitorId(Long visitorId);
}
