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
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;

	@Column(name = "stdName")
	private String stdName;

	@Column(name = "stdDob")
	private String stdDob;

	@Column(name = "stdPercentage")
	private int stdPercentage;

	@Column(name = "stdPhymarks")
	private int stdPhymarks;

	@Column(name = "stdChemarks")
	private int stdChemarks;

	@Column(name = "stdMathsmarks")
	private int stdMathsmarks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Address addressid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "educationid", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Education educationid;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdDob() {
		return stdDob;
	}

	public void setStdDob(String stdDob) {
		this.stdDob = stdDob;
	}

	public int getStdPercentage() {
		return stdPercentage;
	}

	public void setStdPercentage(int stdPercentage) {
		this.stdPercentage = stdPercentage;
	}

	public int getStdPhymarks() {
		return stdPhymarks;
	}

	public void setStdPhymarks(int stdPhymarks) {
		this.stdPhymarks = stdPhymarks;
	}

	public int getStdChemarks() {
		return stdChemarks;
	}

	public void setStdChemarks(int stdChemarks) {
		this.stdChemarks = stdChemarks;
	}

	public int getStdMathsmarks() {
		return stdMathsmarks;
	}

	public void setStdMathsmarks(int stdMathsmarks) {
		this.stdMathsmarks = stdMathsmarks;
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

	@Override
	public String toString() {
		return "Student{" + "studentId=" + studentId + ", stdName='" + stdName + '\'' + ", stdDob='" + stdDob + '\''
				+ ", stdPercentage='" + stdPercentage + '\'' + ", stdPhymarks='" + stdPhymarks + '\''
				+ ", stdChemarks='" + stdChemarks + '\'' + ", stdMathsmarks='" + stdMathsmarks + '\'' + ", addressid='"
				+ addressid + '\'' + ", educationid='" + educationid + '\'' + '}';
	}

}
