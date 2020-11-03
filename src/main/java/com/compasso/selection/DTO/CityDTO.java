package com.compasso.selection.DTO;

public class CityDTO {
    String name;
    String code;
    
    

    public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CityDTO(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}

	
}
