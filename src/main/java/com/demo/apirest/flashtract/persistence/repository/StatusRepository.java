package com.demo.apirest.flashtract.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.apirest.flashtract.percistense.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
