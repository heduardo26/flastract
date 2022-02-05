package com.demo.apirest.flashtract.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.MaterialContract;
import com.demo.apirest.flashtract.persistence.repository.MaterialContractRepository;

@Service
public class MaterialContractService {
	
	@Autowired
	MaterialContractRepository materialContractRepo;
	
	
	public void save(MaterialContract matContract) {
		materialContractRepo.save(matContract);
	}
}
