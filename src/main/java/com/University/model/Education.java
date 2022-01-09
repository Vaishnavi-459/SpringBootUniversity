package com.University.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "education")

public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long educationid;

	@Column(name = "course")
	private String course;

	@Column(name = "university")
	private String university;

	@Column(name = "place")
	private String place;

	@Column(name = "marks")
	private int marks;

	@Column(name = "yop")
	private int yop;

	@Column(name = "department")
	private String department;

	public long geteducationidId() {
		return educationid;
	}

	public void seteducationidId(long educationid) {
		this.educationid = educationid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Education{" + "educationid=" + educationid + ", course='" + course + '\'' + ", university='"
				+ university + '\'' + ", place='" + place + '\'' + ", marks='" + marks + '\'' + ", yop='" + yop + '\''
				+ ", department='" + department + '\'' + '}';
	}

}
