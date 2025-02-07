package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImp;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    // sets the service layer class
    EmployeeController(EmployeeService service) {
        this.service = service;
    }
    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */

    // get request for all employess unfiltered
    @GetMapping
    public List<EmployeeImp> getAllEmployees() {
        return service.getAllEmployees();
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    // get request based on uuid
    @GetMapping("/{uuid}")
    public EmployeeImp getEmployeeByUuid(@PathVariable UUID uuid) {
        return service.getEmployeeByUuid(uuid);
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */

    // post request for creating a new employee
    @PostMapping
    public EmployeeImp createEmployee(@RequestBody EmployeeImp requestBody) { return service.createEmployee(requestBody);}
}
