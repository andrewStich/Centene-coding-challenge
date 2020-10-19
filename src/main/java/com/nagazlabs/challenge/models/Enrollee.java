package com.nagazlabs.challenge.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "enrollee")
public class Enrollee {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@JsonFormat(pattern = "MM-dd-yyyy")
	@Column(name = "birthday")
	private Date birthDate;

	@NotNull
	@Column(name = "active_status")
	private boolean activationStatus;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Transient
	private List<Dependent> dependents;

	public Enrollee() {
		super();
	}

	public Enrollee( int id,  String firstName,  String lastName,
			 Date birthDate,  boolean activationStatus, String phoneNumber,
			 List<Dependent> dependents) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.activationStatus = activationStatus;
		this.phoneNumber = phoneNumber;
		this.dependents = dependents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	public void addDependent(Dependent dependent) {
		dependents.add(dependent);
	}
	
	public void deleteDependent(Dependent dependent) {
		dependents.remove(dependent);
	}

	@Override
	public String toString() {
		return "Enrollee [id=" + id + ", activationStatus=" + activationStatus + ", phoneNumber="
				+ phoneNumber + ", dependents=" + dependents + "]";
	}

}
