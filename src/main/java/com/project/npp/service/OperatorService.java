package com.project.npp.service;

import java.util.List;

import com.project.npp.entities.Operator;
import com.project.npp.exceptions.OperatorNotFoundException;

public interface OperatorService {
	
	// Add operator
	public Operator addOperator(Operator operator);
	
	// Get operator
	public Operator getOperatorByOperatorId(Integer id) throws OperatorNotFoundException;
	public Operator getOperatorByOperatorName(String operatorName) throws OperatorNotFoundException;
	// Update operator
	public Operator updateOperator(Operator operator) throws OperatorNotFoundException;
	
	// Delete operator
	public String deleteOperator(String operatorName) throws OperatorNotFoundException;
	
	// Get all operators
	public List<Operator> getAllOperators() throws OperatorNotFoundException ;
}
