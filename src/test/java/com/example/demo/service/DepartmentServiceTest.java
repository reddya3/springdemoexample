package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department = Department.builder().departmentAddress("Ahmedabad").departmentCode("It-90").departmentId(1L).departmentName("IT").build();

    Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
  }

  @Test
  @DisplayName("Get data based on valid department Name")
  public void whenValidDepartmentName_thenDepartmentShouldFound() {
    String departmentName = "IT";
    Department found = departmentService.fetchDepartmentByName(departmentName);

    assertEquals(departmentName, found.getDepartmentName());
  }
}