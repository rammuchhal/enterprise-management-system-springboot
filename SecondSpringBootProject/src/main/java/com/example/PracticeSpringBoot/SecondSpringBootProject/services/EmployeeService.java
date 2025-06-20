package com.example.PracticeSpringBoot.SecondSpringBootProject.services;

import com.example.PracticeSpringBoot.SecondSpringBootProject.dto.EmployeeDto;
import com.example.PracticeSpringBoot.SecondSpringBootProject.entities.EmployeeEntity;
import com.example.PracticeSpringBoot.SecondSpringBootProject.exceptions.ResourceNotFoundException;
import com.example.PracticeSpringBoot.SecondSpringBootProject.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapping;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapping) {
        this.employeeRepository = employeeRepository;
        this.mapping = mapping;
    }


    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository.findById(Math.toIntExact(id)).map(employeeEntity1->mapping.map(employeeEntity1,EmployeeDto.class));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employees=employeeRepository.findAll();
        return employees.stream()
                .map(employeeEntity -> mapping.map(employeeEntity,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public EmployeeDto addNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity=mapping.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity toBesavedEmployee=employeeRepository.save(employeeEntity);
        return mapping.map(toBesavedEmployee,EmployeeDto.class);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Boolean exists=employeeRepository.existsById(Math.toIntExact(id));
        if(!exists) throw new ResourceNotFoundException("Employee not found with id:"+id);
        EmployeeEntity employeeEntity=mapping.map(employeeDto,EmployeeEntity.class);
        employeeEntity.setId(Math.toIntExact(id));
        EmployeeEntity updatedEmployee=employeeRepository.save(employeeEntity);
        return mapping.map(updatedEmployee,EmployeeDto.class);
    }

    public EmployeeDto updateEmployeePartially(Long id, Map<String,Object> updates) {
        boolean exists=employeeRepository.existsById(Math.toIntExact(id));
        if(!exists) return null;
        EmployeeEntity employeeEntity=employeeRepository.findById(Math.toIntExact(id)).get();
        updates.forEach((field,value)->{
            Field fieldToUpdate= ReflectionUtils.findField(EmployeeEntity.class,field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate,employeeEntity,value);
        });
        return mapping.map(employeeRepository.save(employeeEntity),EmployeeDto.class);
    }

    public Boolean deleteEmployeeById(Long id) {

        if(!employeeRepository.existsById(Math.toIntExact(id))) throw new ResourceNotFoundException("Employee not found with id:"+id);
        employeeRepository.deleteById(Math.toIntExact(id));
        return true;
    }
}
