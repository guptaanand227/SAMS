package com.yswu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class LoginHomeEmbeddable implements Serializable {

	@Column(length = 15)
	private String username;
	@Column(length = 20)
	private String user_type;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "LoginHomeEmbeddable [username=" + username + ", user_type=" + user_type + "]";
	}

}
