package com.compasso.selection.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.entity.Client;
import com.compasso.selection.exceptions.ClientNotFoundException;
import com.compasso.selection.exceptions.NameInvalidException;
import com.compasso.selection.service.ClientService;

@RestController
@RequestMapping("/api/v1/client")
@Api(value = "API de Clientes")
public class ClientController {
    @Autowired
    ClientService service;

    @PostMapping()
    public ResponseEntity<HttpEntity> addClient(@RequestBody ClientDTO clientDTO) throws DateTimeParseException, Exception{
        service.addClient(clientDTO);
        return ResponseEntity.ok().build();


    }
    @GetMapping()
    @ApiOperation(value = "Pesquisa de cliente por name")
    public Client pesquisarClientePorNome(@RequestParam String name) throws ClientNotFoundException{
    		Optional<Client> client = service.findByName(name);
    		if(!client.isPresent()) throw new ClientNotFoundException("Name-" + name);
    		return client.get();
            
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisa de cliente por ID")
    public Client pesquisarClientePorID(@PathVariable Long id) throws ClientNotFoundException{
    		Optional<Client> client = service.findById(id);
    		if(!client.isPresent()) throw new ClientNotFoundException("ID-" + id);
    		return client.get();
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Apagar cliente por ID")
    public ResponseEntity<HttpEntity> deleteClient(@PathVariable Long id) throws EmptyResultDataAccessException {
    	service.deleteById(id);
    	return ResponseEntity.ok().build();
    }
    
    @PutMapping(value="/{id}")
    @ApiOperation(value = "Atualizar Cliente")
    public ResponseEntity<HttpEntity> updateClient(@PathVariable("id") long id, @RequestBody ClientDTO client) throws NameInvalidException, ClientNotFoundException {
       	service.updateClient(id,client);
		return ResponseEntity.ok().build();
	
    }
}
