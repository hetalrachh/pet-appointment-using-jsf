package com.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*Class to store pet details */
@ManagedBean(name = "petDetails", eager = true)
@SessionScoped
public class PetDetails {

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

}
