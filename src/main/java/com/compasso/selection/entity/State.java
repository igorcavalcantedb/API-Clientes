package com.compasso.selection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class State {
    private @Id @GeneratedValue Long id;
    
    @Column
    @NotNull
    @Size(max = 2)
    private String code;
    @Column
    @NotNull
    @Size(max = 50)
    private String name;
    
    @OneToMany(mappedBy="state")
    private List<City> cities;
    

    public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

   
}
