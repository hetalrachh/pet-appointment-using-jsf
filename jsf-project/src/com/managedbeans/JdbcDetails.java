package com.managedbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/*Class to handle JDBC connection to database and implement get and set data to/from db*/
@ManagedBean(name = "jdbcDetails", eager = true)
@SessionScoped
public class JdbcDetails {

	@ManagedProperty(value = "#{userDetails}")
	private UserDetails userDetails;

	@ManagedProperty(value = "#{petDetails}")
	private PetDetails petDetails;

	List<AllDetails> allListDetails = new ArrayList<AllDetails>();

	public List<AllDetails> getAllListDetails() {
		return allListDetails;
	}

	public void setAllListDetails(List<AllDetails> allListDetails) {
		this.allListDetails = allListDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public PetDetails getPetDetails() {
		return petDetails;
	}

	public void setPetDetails(PetDetails petDetails) {
		this.petDetails = petDetails;
	}

	public String addDetails() throws SQLException, ClassNotFoundException {

		Connection con = getConnection();
		PreparedStatement pst = null;
		String addQuery = "INSERT INTO user_pet_details(owner_name, owner_address, owner_contact_no,owner_email_address,"
				+ " pet_name, pet_dob, pet_species, pet_breed, treated_for_illness, problem) VALUES(?,?,?,?,?,?,?,?,?,?)";
		pst = con.prepareStatement(addQuery);
		pst.setString(1, userDetails.getName());
		pst.setString(2, userDetails.getAddress());
		pst.setString(3, userDetails.getContactNo());
		pst.setString(4, userDetails.getEmailAddress());
		pst.setString(5, petDetails.getPetName());
		pst.setString(6, petDetails.getDob());
		pst.setString(7, petDetails.getSpecies());
		pst.setString(8, petDetails.getBreed());
		pst.setString(9, petDetails.getTreatedForIllness());
		pst.setString(10, petDetails.getProblem());
		pst.executeUpdate();

		return "view-submitted-appointment";
	}

	public String getDetails(String ownerName) throws ClassNotFoundException, SQLException {
		allListDetails.clear();

		Connection con = getConnection();
		PreparedStatement pst = null;
		String retrieveQuery = "SELECT * FROM user_pet_details WHERE owner_name=?";
		pst = con.prepareStatement(retrieveQuery);
		pst.setString(1, ownerName);
		ResultSet rst = pst.executeQuery();

		AllDetails allDetails = null;

		while (rst.next()) {

			allDetails = new AllDetails();

			allDetails.setName(rst.getString("owner_name"));
			allDetails.setAddress(rst.getString("owner_address"));
			allDetails.setEmailAddress(rst.getString("owner_email_address"));
			allDetails.setContactNo(rst.getString("owner_contact_no"));

			allDetails.setPetName(rst.getString("pet_name"));
			allDetails.setDob(rst.getString("pet_dob"));
			allDetails.setSpecies(rst.getString("pet_species"));
			allDetails.setBreed(rst.getString("pet_breed"));
			allDetails.setTreatedForIllness(rst.getString("treated_for_illness"));
			allDetails.setProblem(rst.getString("problem"));
			allListDetails.add(allDetails);

		}

		return "view-appointments";
	}

	public Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		String url = "jdbc:postgresql://127.0.0.1/jsf_db";
		String user = "postgres";
		String password = "postgres";
		Class.forName("org.postgresql.Driver");

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println(
					"Exception occured" + ex.getMessage() + " " + ex.fillInStackTrace() + "," + ex.getSQLState());
		}

		return con;

	}

}
