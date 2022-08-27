package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  @Autowired
  private DepartmentRepository departmentRepository;
  @Override
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public List<Department> fetchDepartmentList() {
    return departmentRepository.findAll();
  }

  @Override
  public Department fetchDepartmentById(Long id) {
    return departmentRepository.findById(id).orElseThrow();
  }

  @Override
  public String deleteDepartmentById(Long id) {
    departmentRepository.deleteById(id);
    return "The deleted Id is" + id;
  }

  @Override
  public Department updateDepartment(Long departmentId, Department department) {
    Department depDB = departmentRepository.findById(departmentId).get();
    if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
     depDB.setDepartmentName(department.getDepartmentName());
    }

  }
}
