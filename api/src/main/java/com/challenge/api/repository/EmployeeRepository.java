package com.challenge.api.repository;

import com.challenge.api.model.EmployeeImp;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeImp, UUID> { // key value repository for employees
}
