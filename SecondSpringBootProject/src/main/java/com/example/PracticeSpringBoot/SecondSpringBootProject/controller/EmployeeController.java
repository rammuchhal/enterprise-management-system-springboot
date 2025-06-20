package com.example.PracticeSpringBoot.SecondSpringBootProject.controller;

import com.example.PracticeSpringBoot.SecondSpringBootProject.dto.EmployeeDto;
import com.example.PracticeSpringBoot.SecondSpringBootProject.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    private EmployeeDto employeeDto;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="employeeId") Long id){
            Optional<EmployeeDto> employeeDto=employeeService.getEmployeeById(id);
            return employeeDto
                    .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                    .orElse(null);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.addNewEmployee(employeeDto));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name="employeeId") Long id,
                                                      @RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDto));
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeePartially(@PathVariable(name="employeeId") Long id,
                                                               @RequestBody @Valid  Map<String,Object> updates){
        EmployeeDto employeeDto=employeeService.updateEmployeePartially(id, updates);
        if(employeeDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(name="employeeId") Long id){
        Boolean gotDeleted = employeeService.deleteEmployeeById(id);
        if(gotDeleted) ResponseEntity.ok(gotDeleted);
        return ResponseEntity.notFound().build();
    }

}
