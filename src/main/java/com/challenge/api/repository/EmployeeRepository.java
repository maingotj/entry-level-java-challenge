package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> { // key value repository for employees
}