package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DepartmentService departmentService;

  private Department department;

  @BeforeEach
  void setUp() {
    department = Department.builder().departmentAddress("Ahmedabad").departmentCode("It-90").departmentId(1L).departmentName("IT").build();

  }

  @Test
  void saveDepartment() throws Exception {
//    this is building the department input which matches the output coming
    Department inputDepartment = Department.builder().departmentAddress("Ahmedabad").departmentCode("It-90").departmentId(1L).departmentName("IT").build();

//    this calling the save department and returning the department which we defined
    Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

//    this will call the post method with /departments and then return if the status is okay or not
    mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content(
      "{\n"
          + "\t\"departmentId\":1,\n"
          + "\t\"departmentName\": \"IT\",\n"
          + "\t\"departmentAddress\": \"Ahmedabad\",\n"
          + "\t\"departmentCode\": \"It-90\"\n"
          + "}"
    )).andExpect(status().isOk());


  }

  @Test
  void fetchDepartmentById() throws Exception {

    Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

    mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

  }
}