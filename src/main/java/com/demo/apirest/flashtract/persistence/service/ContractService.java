package com.demo.apirest.flashtract.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.Contract;
import com.demo.apirest.flashtract.persistence.repository.ContractRepository;

@Service
public class ContractService {

	@Autowired
	private ContractRepository contractRepo;
	
	
	public List<Contract> getContracts(){
		return contractRepo.findAll();
	}


	public void save(Contract newContract) {
		contractRepo.saveAndFlush(newContract);
		
	}
	
	/*public List<Contract> getContractsByClient(Client client){
		return contractRepo.findAllByClient(client);
	}*/
}
