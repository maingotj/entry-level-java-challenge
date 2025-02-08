package com.challenge.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
    public CollectionModel<EntityModel<EmployeeImpl>> getAllEmployees() {
        List<EntityModel<EmployeeImpl>> employees = service.getAllEmployees().stream()
                .map(employee -> EntityModel.of(
                        employee,
                        linkTo(methodOn(EmployeeController.class).getEmployeeByUuid(employee.getUuid()))
                                .withSelfRel(),
                        linkTo(methodOn(EmployeeController.class).getAllEmployees())
                                .withRel("all-employees")))
                .collect(Collectors.toList());

        return CollectionModel.of(
                employees,
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withSelfRel());
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */
    // get request based on uuid
    @GetMapping("/{uuid}")
    public EntityModel<EmployeeImpl> getEmployeeByUuid(@PathVariable UUID uuid) {
        EmployeeImpl employee = service.getEmployeeByUuid(uuid);

        return EntityModel.of(
                employee,
                linkTo(methodOn(EmployeeController.class).getEmployeeByUuid(uuid))
                        .withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("all-employees"));
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */

    // post request for creating a new employee
    @PostMapping
    public EntityModel<EmployeeImpl> createEmployee(@RequestBody EmployeeImpl requestBody) {
        EmployeeImpl createdEmployee = service.createEmployee(requestBody);

        return EntityModel.of(
                createdEmployee,
                linkTo(methodOn(EmployeeController.class).getEmployeeByUuid(createdEmployee.getUuid()))
                        .withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("all-employees"));
    }
}
