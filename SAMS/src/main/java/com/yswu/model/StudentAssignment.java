package com.yswu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

	@Id
	@Column(length = 50)
	private String task_id;
	@Column(length = 50)
	private String faculty_username;
	@Column(length = 1000)
	private String task;
	@Column
	@Temporal(TemporalType.DATE)
	private Date end_date;

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getFaculty_username() {
		return faculty_username;
	}

	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
		
	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "StudentAssignment [task_id=" + task_id + ", faculty_username=" + faculty_username + ", task=" + task
				+ ", end_date=" + end_date + "]";
	}

}
