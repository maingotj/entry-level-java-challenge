package com.challenge.api.repository;

import java.util.UUID;

import com.challenge.api.model.EmployeeImp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeImp, UUID> { // key value repository for employees
}