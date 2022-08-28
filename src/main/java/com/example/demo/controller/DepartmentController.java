package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController{

  @Autowired
  private DepartmentService departmentService;

  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {
    LOGGER.info("we are inside the department contorller post mapping");
    return departmentService.fetchDepartmentList();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentById(@PathVariable("id") Long id)
      throws DepartmentNotFoundException {
    return departmentService.fetchDepartmentById(id);
  }

  @GetMapping("/departments/name/{departmentName}")
  public Department fetchDepartmentByName(@PathVariable("departmentName") String departmentName) {
    return  departmentService.fetchDepartmentByName(departmentName);
  }

  @DeleteMapping("/departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long id) {
    return departmentService.deleteDepartmentById(id);
  }

  @PutMapping("/departments/{id}")
  public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
    return departmentService.updateDepartment(departmentId, department);
  }

}
