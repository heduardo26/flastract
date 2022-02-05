package com.demo.apirest.flashtract.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.apirest.flashtract.percistense.model.Contract;
import com.demo.apirest.flashtract.percistense.model.Material;
import com.demo.apirest.flashtract.percistense.model.MaterialContract;


public interface MaterialContractRepository extends JpaRepository<MaterialContract, Integer> {
	
	MaterialContract findFirstByMaterialAndContract (Material material, Contract contract);
	
	//MaterialContract findBMaterialContract(MaterialContract materialContract);
	
	//MaterialContract findFirstByMaterialContract(MaterialContract materialContract);
	
}



