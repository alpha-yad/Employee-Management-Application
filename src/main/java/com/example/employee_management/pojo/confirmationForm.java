package com.example.employee_management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//used when asking the user for confirmation like "Yes" or "No" before performing an action
public class confirmationForm {
  private String confirmation;
}
