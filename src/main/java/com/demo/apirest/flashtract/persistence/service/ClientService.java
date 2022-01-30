package com.demo.apirest.flashtract.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.Client;
import com.demo.apirest.flashtract.persistence.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepo;
	
	public Optional<Client> getClient(Integer id) {
		return clientRepo.findById(id);
	}
}
