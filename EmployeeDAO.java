package com.veltech.dao;

import com.veltech.entity.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

	private Connection con = null;

	public EmployeeDAO(Connection con) {
		this.con= con;
	}

	public boolean addEmployee(Employee e) {
		
		boolean res= false;
		PreparedStatement ps= null;
		try{
			ps= con.prepareStatement("insert into employee values(?, ?, ?)");
			ps.setInt(1, e.getEmpId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSalary());
			int rows= ps.executeUpdate();
			if (rows>0) res= true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}

		return res;
	}

	public Employee getEmployee(int empid) {

		Employee em= null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		try{
			ps= con.prepareStatement("select * from employee where empid=?");
			ps.setInt(1, empid);
			rs= ps.executeQuery();
			if(rs.next())
				em= new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3));
		} catch(Exception e) {
			e.printStackTrace();
		}

		return em;
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> elist= new ArrayList<Employee>();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {

			ps= con.prepareStatement("select * from employee");
			rs= ps.executeQuery();
			while(rs.next()) {
				elist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return elist;		
	}

	public boolean modifyEmployee(int empid) {
		PreparedStatement ps= null;
		int count=0;
		boolean res= false;
		try {
			ps= con.prepareStatement("update employee set salary= ? where empid=?");
			ps.setDouble(1, 999);
			ps.setInt(2, empid);
			count= ps.executeUpdate();
			if (count>0) 
				res= true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public boolean deleteEmployee(int empid) {
		PreparedStatement ps= null;
		int count=0;
		boolean res= false;

		try {
			ps= con.prepareStatement("delete from employee where empid= ?");
			ps.setInt(1, empid);
			count= ps.executeUpdate();
			if(count>0)
				res= true;
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}
}
