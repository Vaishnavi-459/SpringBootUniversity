package com.University.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressid;

	@Column(name = "houseNo")
	private String houseNo;

	@Column(name = "street")
	private String street;

	@Column(name = "locality")
	private String locality;

	@Column(name = "area")
	private String area;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pin")
	private int pin;

	public long getaddressId() {
		return addressid;
	}

	public void setaddressId(long addressid) {
		this.addressid = addressid;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address{" + "addressid=" + addressid + ", houseNo='" + houseNo + '\'' + ", street='" + street + '\''
				+ ", locality='" + locality + '\'' + ", area='" + area + '\'' + ", state='" + state + '\''
				+ ", country='" + country + '\'' + ", pin='" + pin + '\'' +

				'}';
	}

}
