package com.compasso.selection.entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class City {
    private @Id
    @GeneratedValue
    Long id;
    
    @Column
    @NotNull
    @Size(max = 100)
    
    private String name;
    @JsonIgnore
    @ManyToOne
    private State state;
    

    public City() {
		super();
		// TODO Auto-generated constructor stub
	}


	public City(@NotNull @Size(max = 100) String name, State state) {
		super();
		this.name = name;
		this.state = state;
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


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}

	
}
