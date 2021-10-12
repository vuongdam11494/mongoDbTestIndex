package com.example.demo.data.enums;

public enum Gender {
	MALE("name"),FEMALE("female");
	
	private final String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.gender;
	}
}
