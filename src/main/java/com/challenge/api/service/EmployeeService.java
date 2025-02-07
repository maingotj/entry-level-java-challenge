package com.challenge.api.service;

import com.challenge.api.errorHandling.EmployeeNotFoundException;
import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository; // loads in repository
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // gets all employees from repository unfiltered
    }

    public Employee getEmployeeByUuid(UUID uuid) {

        Optional<Employee> employee = employeeRepository.findById(uuid); // loads employee data into employee
        return employee.orElseThrow(
                () -> new EmployeeNotFoundException(uuid)); // throws custom error if employee not found
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee); // handles post request
    }
}
