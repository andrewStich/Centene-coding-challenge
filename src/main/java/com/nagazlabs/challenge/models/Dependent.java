package com.nagazlabs.challenge.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "dependents")
public class Dependent {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "enrollee_id")
	private int enrolleeId;

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

	public Dependent() {
		super();
	}

	public Dependent( int id,  int enrolleeId,  String firstName,  String lastName,
			 Date birthDate) {
		super();
		this.id = id;
		this.enrolleeId = enrolleeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
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

	@Override
	public String toString() {
		return "Dependent [id=" + id + ", enrolleeId=" + enrolleeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + "]";
	}

}
