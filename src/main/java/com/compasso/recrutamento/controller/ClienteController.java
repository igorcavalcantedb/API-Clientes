package com.compasso.recrutamento.controller;

import com.compasso.recrutamento.exceptions.ClientNotFoundException;
import com.compasso.recrutamento.DTO.ClienteDTO;
import com.compasso.recrutamento.entity.Cliente;
import com.compasso.recrutamento.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@Api(value = "API de Clientes")
public class ClienteController {
    @Autowired
    ClienteService service;

    @PostMapping("/")
    public ResponseEntity<HttpEntity> cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        service.cadastrarCliente(clienteDTO);
        return ResponseEntity.ok().build();


    }
    @GetMapping("/")
    @ApiOperation(value = "Pesquisa de cliente por nome")
    public Cliente pesquisarClientePorNome(@RequestParam String name) throws ClientNotFoundException{
    		Optional<Cliente> cliente = service.findByName(name);
    		if(!cliente.isPresent()) throw new ClientNotFoundException("Name-" + name);
    		return cliente.get();
            
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisa de cliente por ID")
    public Cliente pesquisarClientePorID(@PathVariable Long id) throws ClientNotFoundException{
    		Optional<Cliente> cliente = service.pesquisaClientePorID(id);
    		if(!cliente.isPresent()) throw new ClientNotFoundException("ID-" + id);
    		return cliente.get();
    }
    
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
    	service.deletarClientePorId(id);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
       return null;
    }
}
