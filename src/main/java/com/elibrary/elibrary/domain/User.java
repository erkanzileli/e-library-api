package com.elibrary.elibrary.domain;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String username;

	private String password;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String email;

	private String type;

	private int status;

	private boolean isRequested;

	public User(String username, String password, String firstName, String lastName, String email, String type,
			int status, boolean isRequested) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.status = status;
		this.isRequested = isRequested;
	}

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void changePassword(String password){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		this.setPassword(bCryptPasswordEncoder.encode(password));
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isRequested() {
		return isRequested;
	}

	public void setRequested(boolean requested) {
		isRequested = requested;
	}

	public boolean transformUser() {

		if (this.isRequested()) {
			this.setRequested(false);
		} else {
			this.setRequested(true);
		}
		return this.isRequested();
	}

	public User updateUser(String firstName, String lastName, String email) {
		if (firstName!=null) {
			this.setFirstName(firstName);
		}
		if (lastName!=null) {
			this.setLastName(lastName);
		}
		if (email!=null) {
			this.setEmail(email);
		}
		return this;
	}
}
