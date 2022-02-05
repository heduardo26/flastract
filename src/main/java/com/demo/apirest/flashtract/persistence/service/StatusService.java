package com.demo.apirest.flashtract.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.Status;
import com.demo.apirest.flashtract.persistence.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	StatusRepository statusRepo;
	
	public Optional<Status> getStatusById(Integer id) {
		return statusRepo.findById(id);
	}
}
