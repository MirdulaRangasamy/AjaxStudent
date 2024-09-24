package com.exterro.entity;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> studList = new ArrayList<Student>();

	public StudentList() {
		super();

	}

	public ArrayList<Student> getStudList() {
		return studList;
	}

	public void setStudList(ArrayList<Student> studList) {
		this.studList = studList;
	}

	@Override
	public String toString() {
		return "StudentList [studList=" + studList + "]";
	} 
	
}
