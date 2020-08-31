package com.qa.budgetproject.repo;

import com.qa.budgetproject.domain.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<Days, Long> {
}
