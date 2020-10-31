package com.compasso.selection.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.Client;
import com.compasso.selection.repository.CityRepository;
import com.compasso.selection.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CityRepository cityRepository;

	public void addClient(ClientDTO clientDTO) {
		City city = cityRepository.findByName(clientDTO.getCity());
		Client client = new Client(clientDTO, city);
		clientRepository.save(client);
	}

	public Optional<Client> findByName(String name) {
		Optional<Client> client = clientRepository.findByName(name);
		return client;

	}

	public Optional<Client> findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client;
	}

	public void deleteById(Long id) {
		clientRepository.deleteById(id);
		
	}

	public Optional<Client> findById(long id) {
		return clientRepository.findById(id);
		
	}
}
