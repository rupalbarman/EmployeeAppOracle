package com.veltech.entity;

public class Employee {
	private String name;
	private int empid;
	private double salary;

	public Employee() {}

	public Employee(int empid, String name, double salary) {
		this.empid= empid;
		this.name= name;
		this.salary= salary;
	}

	public void setName(String name) {
		this.name= name;
	}

	public void setEmpId(int empid) {
		this.empid= empid;
	}

	public void setSalary(double salary) {
		this.salary= salary;
	}

	public int getEmpId() {
		return this.empid;
	}

	public String getName() {
		return this.name;
	}

	public double getSalary() {
		return this.salary;
	}
}