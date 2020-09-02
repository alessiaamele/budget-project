package com.qa.budgetproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The food with this id doesn't exist")
public class FoodNotFoundException  extends EntityNotFoundException {
}
