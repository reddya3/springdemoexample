package com.example.demo.service;

import com.example.demo.entity.Department;
import java.util.List;

public interface DepartmentService {

  public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();

  public Department fetchDepartmentById(Long id);

  public String deleteDepartmentById(Long id);

  public Department updateDepartment(Long departmentId, Department department);
}
