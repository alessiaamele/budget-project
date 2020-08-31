package com.qa.budgetproject.repo;

import com.qa.budgetproject.domain.Meals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {

}
