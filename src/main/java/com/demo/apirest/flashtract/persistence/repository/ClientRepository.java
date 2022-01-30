package com.demo.apirest.flashtract.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.apirest.flashtract.percistense.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {

}
