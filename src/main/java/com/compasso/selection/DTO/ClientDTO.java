package com.compasso.selection.DTO;

import com.compasso.selection.enums.Gender;

public class ClientDTO {
	private String name;
    private Gender gender;
    private String dateBirth;
    private int age;
    private String city;
    
	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ClientDTO(String name, Gender gender, String dateBirth, int age, String city) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.age = age;
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public String getDateBirth() {
		return dateBirth;
	}


	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	
	

}
