package com.employeedetail.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDetailsRoot {
	 @JsonProperty("Employees") 
	    public ArrayList<Employee> employeeList;

}
