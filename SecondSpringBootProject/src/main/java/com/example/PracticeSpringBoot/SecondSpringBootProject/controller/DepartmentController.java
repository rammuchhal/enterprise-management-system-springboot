package com.example.PracticeSpringBoot.SecondSpringBootProject.controller;

import com.example.PracticeSpringBoot.SecondSpringBootProject.dto.DepartmentDto;
import com.example.PracticeSpringBoot.SecondSpringBootProject.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/{department}")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name="departmentId") Long id){
        Optional<DepartmentDto> departmentDto=departmentService.getDepartmentById(id);
        return departmentDto.map(departmentDto1 -> ResponseEntity.ok(departmentDto1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    ResponseEntity<DepartmentDto> addNewDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.addingNewDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    ResponseEntity<DepartmentDto> updateDepartment(@RequestBody @Valid DepartmentDto departmentDto,
                                                   @PathVariable(name="departmentId") Long id){

        DepartmentDto departmentDto1=departmentService.updateDepartmentById(departmentDto,id);
        return new ResponseEntity<>(departmentDto1,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{departmentId}")
    ResponseEntity<Boolean> deleteDepartment(@PathVariable Long departmentId){
        Boolean toBeDeletedDepartment= departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>(toBeDeletedDepartment,HttpStatus.OK);
    }

    @PatchMapping("/{departmentId}")
    ResponseEntity<DepartmentDto> updateDepartmentPartially(@PathVariable Long departmentId,
                                                            @RequestBody @Valid Map<String,Object> updates){
        DepartmentDto departmenDto= departmentService.updateDepartmentPartiallyById(departmentId,updates);
        if(departmenDto==null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(departmenDto,HttpStatus.OK);
    }
}
