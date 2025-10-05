package com.example.employee_management.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
  @Id private String id;
  private String employeeName;
  private String employeeEmail;
  private Long employeePhone;
  private String employeeGender;
  private String employeeSalary;
  private String employeeRole;
}
