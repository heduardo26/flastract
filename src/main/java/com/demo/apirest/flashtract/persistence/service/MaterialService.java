package com.demo.apirest.flashtract.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.Material;
import com.demo.apirest.flashtract.persistence.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	MaterialRepository materialRepo;
	
	public Optional<Material> getMaterialById(Integer id) {
		return materialRepo.findById(id);
	}
}
