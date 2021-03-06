package com.compasso.selection.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Client {
    private @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "Name must be valid")
    private String name;
    private Gender gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate dateBirth;
    @Min(value = 5, message = "The age shold be more then 5")
    @Max(value = 120, message ="The age shold be less then 120")
    private int age;
    @ManyToOne
    private City city;

    public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Client(ClientDTO clientDTO , City city) {
    	this.name = clientDTO.getName();
    	this.gender= clientDTO.getGender();
    	this.dateBirth = LocalDate.parse(clientDTO.getDateBirth());
    	this.age = clientDTO.getAge();
    	this.city = city;

    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
    
    
	
}
