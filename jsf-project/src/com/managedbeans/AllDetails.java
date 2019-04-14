package com.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*Class to store owner+pet details obtained from db*/
@ManagedBean(name = "allDetails", eager = true)
@SessionScoped
public class AllDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private String contactNo;
	private String emailAddress;
	private String petName;
	private String dob;
	private String species;
	private String breed;
	private String treatedForIllness;
	private String problem;

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getTreatedForIllness() {
		return treatedForIllness;
	}

	public void setTreatedForIllness(String treatedForIllness) {
		this.treatedForIllness = treatedForIllness;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
