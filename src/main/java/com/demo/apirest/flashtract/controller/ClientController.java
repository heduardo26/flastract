package com.demo.apirest.flashtract.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.apirest.flashtract.percistense.model.Client;
import com.demo.apirest.flashtract.percistense.model.Contract;
import com.demo.apirest.flashtract.percistense.model.Vendor;
import com.demo.apirest.flashtract.percistense.model.dto.ContractDto;
import com.demo.apirest.flashtract.persistence.service.ClientService;
import com.demo.apirest.flashtract.persistence.service.ContractService;
import com.demo.apirest.flashtract.persistence.service.VendorService;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired 
	ClientService clientService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	ContractService contractService;
	
	@GetMapping("/getUsuarios")
	public String getUsuarios() {
		return "acaaaaaaaaaa!!!!!!!!!";
	}
	
	@GetMapping(path = "/getAllUsuarios")
	public ResponseEntity<Map<String, Object>> index(){
		
		Map<String, Object> response = new HashMap<>();
		System.out.println("Inside***************");
		response.put("usuarios", "users");
		//Devolvemos el listado de usuarios
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	/**
	 * Endpoint to generate a new contract
	 * @return
	 */
	@PostMapping("/createContract")
	public ResponseEntity<Map<String, Object>> createContract(@RequestBody ContractDto contract, BindingResult result){
		System.out.println("Create contract");
		Map<String, Object> response = new HashMap<>();
		
		//Validate that the client exists
		Optional<Client> client  = clientService.getClient(contract.getClienteId());
		if (!client .isPresent()) {
			response.put("message", "Client doesn't exists!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		//Validate that the vendor exits 
		Optional<Vendor> vendor = vendorService.getVendor(contract.getVendorId());
		if(!vendor.isPresent()) {
			response.put("message", "Vendor doesn't exist!");
		}
		
		Contract newContract = new Contract();
		
		newContract.setDescription(contract.getDescription());
		newContract.setAmount(contract.getAmount());
		newContract.setBalance(contract.getBalance());
		newContract.setCliente(client.get());
		newContract.setVendor(vendor.get());
		newContract.setCreateAt(contract.getCreateAt());
		
		contractService.save(newContract);
		
		
		response.put("Client", newContract );
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}