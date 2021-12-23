package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;
	
	@NotNull(message="First name is compulsary")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message="Middle name is compulsary")
	@Column(name = "middle_name")
	private String middleName;
	
	@NotNull(message="Last name is compulsary")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message="Email is compulsary")
	@Column(name = "email_")
	private String email;

	@NotNull(message="Contact number is compulsary")
	@Column(name = "contact")
	private String contact;
	

	@NotNull(message="Gender is compulsary")
	@Column(name = "gender")
	private String gender;
	
	@NotNull(message="Date of birth is compulsary")
	@Column(name = "birth_date")
	private String birth_date;

	@NotNull(message="Member type is compulsary")
	@Column(name = "member_type")
	private String memberType;
	
	public Student() {
		
	}
	
	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Student(int id, @NotNull(message = "First name is compulsary") String firstName,
			@NotNull(message = "Middle name is compulsary") String middleName,
			@NotNull(message = "Last name is compulsary") String lastName,
			@NotNull(message = "Email is compulsary") String email,
			@NotNull(message = "Contact number is compulsary") String contact,
			@NotNull(message = "Gender is compulsary") String gender,
			@NotNull(message = "Date of birth is compulsary") String birth_date,
			@NotNull(message = "Member type is compulsary") String memberType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.birth_date = birth_date;
		this.memberType = memberType;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

}
