### add a new employee
curl -X POST 'http://localhost:8080/api/v1/employee' \
-H 'Content-Type: application/json' \
-d '{
    "uuid": "123e4567-e89b-12d3-a456-426614174000",
    "firstName": "Jonathan",
    "lastName": "Maingot",
    "fullName": "Jonathan Paul Sherlock Maingot",
    "salary": 20000,
    "age": 22,
    "jobTitle": "Junior Software Engineer",
    "contractHireDate": "2024-02-06T12:00:00Z"
    }'




### check for non existent employee
curl -v localhost:8080/api/v1/employee/4d9ebaa9-4fe7-4548-b009-99934d07e41b
