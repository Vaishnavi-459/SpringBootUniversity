package com.University.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeid;

	@Column(name = "empName")
	private String empName;

	@Column(name = "empSalary")
	private Double empSalary;

	@Column(name = "empDoj")
	private int empDoj;

	@Column(name = "empDob")
	private String empDob;

	@Column(name = "empDesignation")
	private String empDesignation;

	@Column(name = "empBonus")
	private double empBonus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Address addressid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "educationid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Education educationid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "experienceid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Experience experienceid;

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(int empDoj) {
		this.empDoj = empDoj;
	}

	public String getEmpDob() {
		return empDob;
	}

	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public double getEmpBonus() {
		return empBonus;
	}

	public void setEmpBonus(double empBonus) {
		this.empBonus = empBonus;
	}

	public Address getAddressid() {
		return addressid;
	}

	public void setAddressid(Address addressid) {
		this.addressid = addressid;
	}

	public Education getEducationid() {
		return educationid;
	}

	public void setEducationid(Education educationid) {
		this.educationid = educationid;
	}

	public Experience getExperienceid() {
		return experienceid;
	}

	public void setExperienceid(Experience experienceid) {
		this.experienceid = experienceid;
	}

	@Override
	public String toString() {
		return "Employee{" + "employeeid=" + employeeid + ", empName='" + empName + '\'' + ", empSalary='" + empSalary
				+ '\'' + ", empDoj='" + empDoj + '\'' + ", empDob='" + empDob + '\'' + ", empDesignation='"
				+ empDesignation + '\'' + ", empBonus='" + empBonus + '\'' + ", addressid='" + addressid + '\''
				+ ", educationid='" + educationid + '\'' + ", experienceid='" + experienceid + '\'' + '}';
	}

}
