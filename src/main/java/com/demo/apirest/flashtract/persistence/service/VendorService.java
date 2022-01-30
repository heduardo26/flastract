package com.demo.apirest.flashtract.persistence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.apirest.flashtract.percistense.model.Vendor;
import com.demo.apirest.flashtract.persistence.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepo;
	
	public Optional<Vendor> getVendor(Integer id) {
		return vendorRepo.findById(id);
	}
}
