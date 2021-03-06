package com.alazarbank.models;

import java.util.ArrayList;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String pass_hash;
	private ArrayList<Integer> acctNumbers = new ArrayList<Integer>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass_hash() {
		return pass_hash;
	}
	public void setPass_hash(String pass_hash) {
		this.pass_hash = pass_hash;
	}
	
	public ArrayList<Integer> getAcctNumbers() {
		return acctNumbers;
	}
	
	public void setAcctNumbers(ArrayList<Integer> acctNumbers) {
		this.acctNumbers = acctNumbers;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", pass_hash=" + pass_hash + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pass_hash == null) ? 0 : pass_hash.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pass_hash == null) {
			if (other.pass_hash != null)
				return false;
		} else if (!pass_hash.equals(other.pass_hash))
			return false;
		return true;
	}
	
	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, String email, String pass_hash) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass_hash = pass_hash;
	}
}
