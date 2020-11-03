package com.compasso.selection.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.Client;
import com.compasso.selection.exceptions.ClientNotFoundException;
import com.compasso.selection.exceptions.NameInvalidException;
import com.compasso.selection.repository.CityRepository;
import com.compasso.selection.repository.ClientRepository;
import com.compasso.selection.utils.NameValidator;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	CityRepository cityRepository;

	public void addClient(ClientDTO clientDTO) throws NameInvalidException,Exception {
		String name = clientDTO.getName();
		if(!NameValidator.isNameValid(name)){
			throw new NameInvalidException("name" + name);
		}
		City city = cityRepository.findByName(clientDTO.getCity());
		if(city == null) {
			throw new Exception("Invalid City");
		}
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

	public void updateClient(long id, ClientDTO clientDTO) throws NameInvalidException, ClientNotFoundException {
		String newName = clientDTO.getName();
		if(NameValidator.isNameValid(newName)){
			Optional<Client> client =clientRepository.findById(id);
			if(client.isPresent()) {
				Client clientUpdated =  client.get();
				clientUpdated.setName(newName);
				clientRepository.save(clientUpdated);
				}
			else throw new ClientNotFoundException();
			
		}
		else throw new NameInvalidException("Name = "+ clientDTO.getName());
			
	}
	
}
