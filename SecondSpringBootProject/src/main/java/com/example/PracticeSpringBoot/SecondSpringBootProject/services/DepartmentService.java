package com.example.PracticeSpringBoot.SecondSpringBootProject.services;

import com.example.PracticeSpringBoot.SecondSpringBootProject.dto.DepartmentDto;
import com.example.PracticeSpringBoot.SecondSpringBootProject.entities.DepartmentEntity;
import com.example.PracticeSpringBoot.SecondSpringBootProject.entities.EmployeeEntity;
import com.example.PracticeSpringBoot.SecondSpringBootProject.exceptions.ResourceNotFoundException;
import com.example.PracticeSpringBoot.SecondSpringBootProject.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapping;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper mapping) {
        this.departmentRepository = departmentRepository;
        this.mapping = mapping;
    }

    public Optional<DepartmentDto> getDepartmentById(Long id) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        return departmentEntity.map(departmentEntity1->
                mapping.map(departmentEntity1,DepartmentDto.class));
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departments=departmentRepository.findAll();
        return departments.stream().map(departmentEntity ->
                mapping.map(departmentEntity,DepartmentDto.class)).toList();
    }

    public DepartmentDto addingNewDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity=mapping.map(departmentDto,DepartmentEntity.class);
        DepartmentEntity saveToDepartment =departmentRepository.save(departmentEntity);
        return mapping.map(departmentRepository.save(departmentEntity),DepartmentDto.class);
    }

    public DepartmentDto updateDepartmentById(DepartmentDto departmentDto, Long id) {
        Boolean exists=departmentRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Department not found"+id);
        }
        DepartmentEntity departmentEntity=mapping.map(departmentDto,DepartmentEntity.class);
        departmentEntity.setId(id);
        return mapping.map(departmentRepository.save(departmentEntity),DepartmentDto.class);
    }

    public Boolean deleteDepartmentById(Long id) {
        if(!departmentRepository.existsById(id)) throw new ResourceNotFoundException("department not exists");
        departmentRepository.deleteById(id);
        return true;
    }

    public DepartmentDto updateDepartmentPartiallyById(Long departmentId, Map<String,Object> updates) {
        if(!departmentRepository.existsById(departmentId)) throw new ResourceNotFoundException("not found");
        DepartmentEntity departmentEntity=departmentRepository.findById(departmentId).get();
        updates.forEach((field,value)->{
            Field fieldToBeUpdated= org.springframework.util.ReflectionUtils.findField(DepartmentEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,departmentEntity,value);
        });
        return mapping.map(departmentRepository.save(departmentEntity),DepartmentDto.class);
    }
}
