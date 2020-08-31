package com.qa.budgetproject.repo;

import com.qa.budgetproject.domain.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepository extends JpaRepository<Foods, Long> {
}
