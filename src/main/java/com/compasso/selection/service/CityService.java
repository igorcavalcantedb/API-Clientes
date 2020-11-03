package com.compasso.selection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.State;
import com.compasso.selection.exceptions.CityAlreadyExistsException;
import com.compasso.selection.exceptions.StateNotFoundException;
import com.compasso.selection.repository.CityRepository;
import com.compasso.selection.repository.StateRepository;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;

    public Iterable<City> findAllCities(){
        return cityRepository.findAll();
    }

    public void addCity(CityDTO cidadeDto) throws CityAlreadyExistsException, StateNotFoundException {
          Optional<State> stateOptional = stateRepository.findByCode(cidadeDto.getCode());
         
        if(!stateOptional.isPresent()) {
        	 throw new StateNotFoundException("Code = "+ cidadeDto.getCode());
        }
        else {
        	State state = stateOptional.get();
        	if (isCityinThisState(cidadeDto.getName(),state)){
        		throw new CityAlreadyExistsException("City = " + cidadeDto.getName());
        	}
        	else {
        		City city = new City(cidadeDto.getName(),state);
                cityRepository.save(city);
        	}
        	
        }
       
    }
    
    public City findByName(String name) {
     	return cityRepository.findByName(name);
	  	
    }
    
	public List<City> findByState(String code) throws StateNotFoundException{
		Optional<State> stateOptional = stateRepository.findByCode(code);
        //Todo Tratar o erro se nao retornar nenhum estado
		if(!stateOptional.isPresent()) {
			throw new StateNotFoundException("Code =" + code);
		}
        State state = stateOptional.get();
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
