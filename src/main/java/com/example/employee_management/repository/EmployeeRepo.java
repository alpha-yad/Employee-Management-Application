package com.example.employee_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.employee_management.pojo.Employee;
@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String>{
  
}
