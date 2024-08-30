package com.Tap.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Tap.Connect.MyConnection;
import com.Tap.dao.EmployeeDAO;
import com.Tap.models.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private MyConnection mycon = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet result = null; 
	
	public EmployeeDAOImpl() {
		mycon = MyConnection.getMyConnection();
		con = mycon.connect();
	}
	

	@Override
	public int insertEmployee(Employee e) {
		try {
			
			pstmt = con.prepareStatement("Insert into employee(empid, empname, dept, salary, email) values(?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, e.getEmpid());
			pstmt.setString(2, e.getEmpname());
			pstmt.setString(3, e.getDepartment());
			pstmt.setInt(4, e.getSalary());
			pstmt.setString(5, e.getEmail());
			
			return pstmt.executeUpdate();
		}
		catch(Exception a) {
			a.printStackTrace();
			return 0;
		}
	}
	

	@Override
	public ResultSet fetchAllEmployee() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery("select * from employee");
			return result;
		}
		catch(Exception e) {
			return null;
		}
	}
	

	@Override
	public ResultSet fetchOneEmployee(int empid) {
		try {
			pstmt = con.prepareStatement("Select * from employee where empid = ?");
			pstmt.setInt(1, empid);
			return (ResultSet) pstmt.executeQuery();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public int updateEmployee(int empid, int percent) {
		try {
			pstmt = con.prepareStatement("Update employee set salary = salary + salary * ? / 100 where empid = ?");
			pstmt.setInt(1, percent);
			pstmt.setInt(2, empid);
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	@Override
	public int deleteEmployee(int empid) {
		try {
			pstmt = con.prepareStatement("Delete from employee where empid = ?");
			pstmt.setInt(1, empid);
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
