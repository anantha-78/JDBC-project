package com.Tap.main;

import java.sql.ResultSet;
import java.util.Scanner;

import com.Tap.dao.EmployeeDAO;
import com.Tap.daoImpl.EmployeeDAOImpl;
import com.Tap.models.Employee;

public class Demo123 {
	
	private static int empid, salary;
	private static String empname, dept, email;
	private static String option = "yes";
	
	public static void main(String[] args) {
		try {
			EmployeeDAO empdao = new EmployeeDAOImpl();
			
			while(option .equals("yes")) {
				System.out.println("Choose any operation: \n1. Display Whole Table \n2. Display a Particular Record \n3. Insert a Record \n4. Update a Record \n5. Delete a Record\n");
				
				Scanner scan = new Scanner(System.in);
				Scanner sc =new Scanner(System.in);
				int choice = scan.nextInt();
				switch(choice) {
				
				case 1:
					ResultSet result = empdao.fetchAllEmployee();
					while(result.next() == true) {
						empid = result.getInt(1);
						empname = result.getString(2);
						dept = result.getString(3);
						salary = result.getInt(4);
						email = result.getString(5);
						System.out.printf("%-3d  %-20s %-10s %-6d %s \n",empid, empname, dept, salary, email);
					}
					break;
					
				case 2:
					System.out.println("Enter Employee Id of an Employee: ");
					empid = scan.nextInt();
					ResultSet res = empdao.fetchOneEmployee(empid);
					while(res.next() == true) {
						empid = res.getInt(1);
						empname = res.getString(2);
						dept = res.getString(3);
						salary = res.getInt(4);
						email = res.getString(5);
						System.out.printf("%-3d  %-20s %-10s %-6d %s \n",empid, empname, dept, salary, email);
					}
					break;
					
				case 3:
					System.out.println("Enter Employee ID: ");
					empid = scan.nextInt();
					System.out.println("Enter Employee Name: ");
					empname = sc.nextLine();
					System.out.println("Enter Employee Department: ");
					dept = sc.nextLine();
					System.out.println("Enter Employee Salary: ");
					salary = scan.nextInt();
					System.out.println("Enter Employee EmailID: ");
					email = sc.nextLine();
					
					Employee emp2 = new Employee(empid, empname, dept, salary, email);
					System.out.println(empdao.insertEmployee(emp2) + " rows inserted successfully");
					break;
					
				case 4:
					System.out.println("Enter Employee Id: ");
					empid = scan.nextInt();
					System.out.println("Enter the percent: ");
					int percent = scan.nextInt();
					System.out.println(empdao.updateEmployee(empid, percent) + "rows updated successfully...");
					break;
					
				case 5:
					System.out.println("Enter Employee Id: ");
					empid = scan.nextInt();
					System.out.println(empdao.deleteEmployee(empid) + " row deleted successfully..");
					break;
					
				default:
					System.out.println("Invalid option. Please enter correctly...");
				}
				
				System.out.println("Do you want to continue (yes/no): ");
				option = sc.nextLine().toLowerCase();
				
			}
		}
		catch(Exception e) {
			System.out.println("Error Occured..");
		}
		finally {
			System.out.println("Connection Terminated..");
		}
	}
}
