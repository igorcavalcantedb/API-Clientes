package com.compasso.selection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.State;
import com.compasso.selection.repository.CityRepository;
import com.compasso.selection.repository.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    public Iterable<City> findAllCities(){
        return cityRepository.findAll();
    }

    public void addCity(CityDTO cidadeDto) {
        Optional<State> estadoOptional = stateRepository.findByCode(cidadeDto.getCode());
        //Todo Tratar o erro se nao retornar nenhum estado
        if(estadoOptional.isPresent()) {
        	State state = estadoOptional.get();
        	if (isCityinThisState(cidadeDto.getName(),state)){
        		City city = new City(cidadeDto.getName(),state);
                cityRepository.save(city);
        	}
        	 
            
        }
       
    }
    
    public City findByName(String name) {
     	return cityRepository.findByName(name);
	  	
    }
    
	public List<City> findByState(String code){
		Optional<State> estadoOptional = stateRepository.findByCode(code);
        //Todo Tratar o erro se nao retornar nenhum estado
        State state = estadoOptional.get();
        List<City> cities = cityRepository.findByState(state);
		return cities;
		
		
	}
	
	private boolean isCityinThisState(String nameCity,State state) {
		boolean anyMatch = cityRepository.findByState(state).stream().anyMatch(cidade -> cidade.getName().equals(nameCity));
		return anyMatch ?  true : false; 
		
	}

	public void deleteById(Long id) {
		cityRepository.deleteById(id);
		
	}
}
