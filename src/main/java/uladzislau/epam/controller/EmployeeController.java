package uladzislau.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uladzislau.epam.service.EmployeeService;
import uladzislau.epam.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<String> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving employees: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/javaAPI/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployeesJavaAPI() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployeesJavaAPI(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> createEmployee(@PathVariable String id, @RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.createEmployee(id, employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        try {
            return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting employee: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<String> searchEmployees(@RequestParam String field, @RequestParam String value) {
        try {
            return new ResponseEntity<>(employeeService.searchEmployees(field, value), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error searching employees: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}