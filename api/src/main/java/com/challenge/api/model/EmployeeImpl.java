package com.challenge.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class EmployeeImpl implements Employee {

    @Id
    @GeneratedValue
    private UUID uuid; // the key

    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate = null; // defaults to null until termination

    //    constructor for employee creation
    public EmployeeImpl(
            String firstName,
            String lastName,
            String fullName,
            Integer salary,
            Integer age,
            String jobTitle,
            String email,
            Instant contractHireDate,
            Instant contractTerminationDate) {
        this.uuid = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.salary = salary;
        this.age = age;
        this.jobTitle = jobTitle;
        this.email = email;
        this.contractHireDate = contractHireDate;
        this.contractTerminationDate = contractTerminationDate;
    }

    public EmployeeImpl() {}

    @Override
    public UUID getUuid() {
        return uuid; // Return actual UUID field
    }

    @Override // left as set uuid
    public void setUuid(UUID uuid) {
        this.uuid = uuid; // Set UUID field and allows custom UUID
    }

    @Override
    public String getFirstName() {
        return firstName; // Return actual firstName field
    }

    @Override
    public void setFirstName(String name) {
        this.firstName = name; // Set firstName field
    }

    @Override
    public String getLastName() {
        return lastName; // Return actual lastName field
    }

    @Override
    public void setLastName(String name) {
        this.lastName = name; // Set lastName field
    }

    @Override
    public String getFullName() {
        return fullName; // Return actual fullName field
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name; // Set fullName field
    }

    @Override
    public Integer getSalary() {
        return salary; // Return actual salary field
    }

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary; // Set salary field
    }

    @Override
    public Integer getAge() {
        return age; // Return actual age field
    }

    @Override
    public void setAge(Integer age) {
        this.age = age; // Set age field
    }

    @Override
    public String getJobTitle() {
        return jobTitle; // Return actual jobTitle field
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle; // Set jobTitle field
    }

    @Override
    public String getEmail() {
        return email; // Return actual email field
    }

    @Override
    public void setEmail(String email) {
        this.email = email; // Set email field
    }

    @Override
    public Instant getContractHireDate() {
        return contractHireDate; // Return actual contractHireDate field
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.contractHireDate = date; // Set contractHireDate field
    }

    @Override
    public Instant getContractTerminationDate() {
        return contractTerminationDate; // Return actual contractTerminationDate field
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date; // Set contractTerminationDate field
    }
}
