package com.exterro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class Student implements Serializable{
	@Id
	private int rollNo;
	private String name;
	private String dept;
	private float grade;
	public Student() {
		super();

	}
	public Student(int rollNo, String name, String dept, float grade) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dept=" + dept + ", grade=" + grade + "]";
	}
}