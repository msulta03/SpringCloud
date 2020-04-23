package com.moe.mvc1.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestModel {

	@NotNull(message = "Firstname cannot be null")
	private String firstname;
	@NotNull
	private String lastname;
	@Email
	private String email;
	
	@NotNull(message = "another custom message from password this time")
	@Size(min=6, max=16, message = "another custom error message from size annotation")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
