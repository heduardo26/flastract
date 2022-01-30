package com.demo.apirest.flashtract.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.apirest.flashtract.percistense.model.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer>{

	
	
}
