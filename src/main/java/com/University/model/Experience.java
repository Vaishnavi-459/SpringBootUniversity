package com.University.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "experience")
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long experienceid;

	@Column(name = "organisationName")
	private String organisationName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "exp")
	private int exp;

	public long getexperienceId() {
		return experienceid;
	}

	public void setexperienceId(long experienceid) {
		this.experienceid = experienceid;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Experience{" + "experienceid=" + experienceid + ", organisationName='" + organisationName + '\''
				+ ", designation='" + designation + '\'' + ", exp='" + exp + '\'' + '}';
	}

}
