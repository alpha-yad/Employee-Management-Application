package com.example.employee_management.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.employee_management.pojo.Employee;
import com.example.employee_management.pojo.confirmationForm;
import com.example.employee_management.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class EmployeeController {
  @Autowired
  private EmployeeRepo employeeRepo;
  //display to html pages
  @GetMapping("/")
  public String getAllEmployees(Model model) {

      List<Employee> employeeList = employeeRepo.findAll();
      model.addAttribute("employees",employeeList);
      model.addAttribute("employee",new Employee());
      model.addAttribute("confirmationForm", new confirmationForm());
      return "index";
  }
  //crud operation
  //Insert new Employee data
  @PostMapping("/create")
  public String newEmployee(Employee employee,Model model) {
      model.addAttribute("employee", new Employee());
      //creating dynamic EmpId
      String empId = "EMP";
      Random random = new Random();
      long randNumber = 1000 + random.nextInt(9000);
      empId = empId + randNumber;
      employee.setId(empId);
      //save the employee
      employeeRepo.save(employee);
      return "redirect:/";
  }
  //update the existing employee
 @PostMapping("/update")
public String updateEmployee(@ModelAttribute Employee employee, Model model) {
    Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());

    if (existingEmployee.isPresent()) {
        employeeRepo.save(employee);
    } else {
        model.addAttribute("errorMessage", "Employee with ID " + employee.getId() + " not found.");
    }

    return "redirect:/";
}

  // delete an employee by Id
@PostMapping("/remove")
public String deleteEmployee(@ModelAttribute Employee employee, Model model) {
    Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());
    
    if (existingEmployee.isPresent()) {
        employeeRepo.deleteById(employee.getId());
    } else {
        model.addAttribute("alertMessage", "Employee with ID " + employee.getId() + " not found.");
    }

    return "redirect:/";
}

  // delete all employees data from 
  @PostMapping("/remove/all")
  public String removeAll(@ModelAttribute confirmationForm confirmationForm, Model model) {
    String confirmation = confirmationForm.getConfirmation();
    if ("Yes".equalsIgnoreCase(confirmation)) {
        employeeRepo.deleteAll();
    }
    return "redirect:/";
}
  
}
