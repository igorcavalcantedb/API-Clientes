package com.compasso.selection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.selection.entity.City;
import com.compasso.selection.repository.StateRepository;

@Service
public class StateService {
	@Autowired
	StateRepository stateRepository;

	public Iterable<City> listarCidadesPorEstado(String code) {
		// TODO Auto-generated method stub
		stateRepository.findByCode(code);
		return null;
	}
	

}
