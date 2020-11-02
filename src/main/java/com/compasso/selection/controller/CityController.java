package com.compasso.selection.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.entity.City;
import com.compasso.selection.exceptions.CityAlreadyExistsException;
import com.compasso.selection.exceptions.StateNotFoundException;
import com.compasso.selection.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
	@Autowired
	private CityService service;

	@GetMapping("/all")
	@ApiOperation(value = "Listar todas as cidades ")
	public Iterable<City> listarTodasCidades() {
		return service.findAllCities();
	}

	@ApiOperation(value = "Adicionar Cidade à Estado(UF) ")
	@PostMapping()
	public ResponseEntity<HttpEntity> addCity(@RequestBody CityDTO cidade) throws CityAlreadyExistsException, StateNotFoundException {
		service.addCity(cidade);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Pesquisar cidade por name ")
	@GetMapping("/{name}")
	public City findCityByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@ApiOperation(value = "Listar as cidade de um Estado(UF) ")
	@GetMapping()
	public List<City> findCityByState(@RequestParam String code) throws StateNotFoundException {
		return service.findByState(code);
	}
	@DeleteMapping("/{id}")
    @ApiOperation(value = "Apagar Cidade por ID")
    public ResponseEntity<HttpEntity> deleteCity(@PathVariable Long id) {
    	service.deleteById(id);
    	return ResponseEntity.ok().build();
    }
}
