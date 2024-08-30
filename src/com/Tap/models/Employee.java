package com.Tap.models;

public class Employee {
	
	private int empid, salary;
	private String empname, department, email;
	
	public Employee(int empid, String empname, String department, int salary , String email) {
		this.empid = empid;
		this.salary = salary;
		this.empname = empname;
		this.department = department;
		this.email = email;
	}
	
	public int getEmpid() {
		return empid;
	}
	
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getEmpname() {
		return empname;
	}
	
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "EmployeeDAO [empid=" + empid + ", salary=" + salary + ", empname=" + empname + ", department="
				+ department + ", email=" + email + "]";
	}
	
}
