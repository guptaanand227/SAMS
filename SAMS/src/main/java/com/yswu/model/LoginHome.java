package com.yswu.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class LoginHome {

	@EmbeddedId
	private LoginHomeEmbeddable loginHomeEmbeddable;
	@Column
	@Lob
	private byte[] password;
	@Column(length = 50)
	private String firstname;
	@Column(length = 50)
	private String lastname;
	@Column(length = 450)
	private String email_id;
	@Column(length = 20)
	private String contact_no;

	public LoginHomeEmbeddable getLoginHomeEmbeddable() {
		return loginHomeEmbeddable;
	}

	public void setLoginHomeEmbeddable(LoginHomeEmbeddable loginHomeEmbeddable) {
		this.loginHomeEmbeddable = loginHomeEmbeddable;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	@Override
	public String toString() {
		return "LoginHome [loginHomeEmbeddable=" + loginHomeEmbeddable + ", password=" + Arrays.toString(password)
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email_id=" + email_id + ", contact_no="
				+ contact_no + "]";
	}

	

}
