package com.project.npp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.npp.entities.Operator;

@Repository
public interface OperatorRepository  extends CrudRepository<Operator, String>{
	public Optional<Operator> findByOperatorId(Integer operatorId);

}
