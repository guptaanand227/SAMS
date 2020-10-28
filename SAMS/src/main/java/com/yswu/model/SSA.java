package com.yswu.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "student_submitted_assignment")
public class SSA {

	@Id
	@Column(length = 50)
	private String stutask_id;
	@Column(length = 50)
	private String faculty_username;
	@Column(length = 50)
	private String student_username;
	@Column(length = 50)
	private String task_id;
	@Column
	@Lob
	private byte[] uploaded_file;

	public String getStutask_id() {
		return stutask_id;
	}

	public void setStutask_id(String stutask_id) {
		this.stutask_id = stutask_id;
	}

	public String getFaculty_username() {
		return faculty_username;
	}

	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}

	public String getStudent_username() {
		return student_username;
	}

	public void setStudent_username(String student_username) {
		this.student_username = student_username;
	}	

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public byte[] getUploaded_file() {
		return uploaded_file;
	}

	public void setUploaded_file(byte[] uploaded_file) {
		this.uploaded_file = uploaded_file;
	}

	@Override
	public String toString() {
		return "SSA [stutask_id=" + stutask_id + ", faculty_username=" + faculty_username + ", student_username="
				+ student_username + ", task_id=" + task_id + ", uploaded_file=" + Arrays.toString(uploaded_file) + "]";
	}

}
