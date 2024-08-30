package com.Tap.dao;

import java.sql.ResultSet;

import com.Tap.models.Employee;

public interface EmployeeDAO {
	
	int insertEmployee(Employee e);
	ResultSet fetchAllEmployee();
	ResultSet fetchOneEmployee(int empid);
	int updateEmployee(int empid, int percent);
	int deleteEmployee(int empid);
}