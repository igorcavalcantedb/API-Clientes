package com.compasso.selection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.controller.CityController;
import com.compasso.selection.controller.ClientController;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.State;
import com.compasso.selection.enums.Gender;
import com.compasso.selection.repository.StateRepository;
import com.compasso.selection.service.ClientService;


@SpringBootTest
class SelectionApplicationTests {
@Autowired
StateRepository stateRepository;
@Autowired
CityController cityController;
@Autowired
ClientController clientController;	

	@BeforeEach
	void contextLoads() {
		
		
	}
	
	@Test
	void cadastrarCidade() {
		String nomeCidade = "Itajaí";
		CityDTO cityDTO = new CityDTO(nomeCidade,"SC");
		int statusCode = cityController.addCity(cityDTO).getStatusCodeValue();
		assertEquals(200,statusCode);
	}
	@Test
	void cadastrarCliente() {
		ClientDTO clientDTO = new ClientDTO( "Igor Cavalcante",Gender.MALE,"1986-10-23",34,"Fortaleza");
		int statusCode = clientController.addClient(clientDTO).getStatusCodeValue();
		assertEquals(200,statusCode);
	}
	@Test
	void pesquisarCidadePorNome() {
		String nomeCidade = "Fortaleza";
		CityDTO cityDTO = new CityDTO(nomeCidade,"CE");
		cityController.addCity(cityDTO);
		City city= cityController.findCityByName(nomeCidade);
		assertEquals(nomeCidade, city.getName());
	}
	@Test
	void pesquisarCidadePorEstado() {
		String code = "SC";  
		String nomeCidade = "Itajaí";
		CityDTO cityDTO = new CityDTO(nomeCidade,code);
		cityController.addCity(cityDTO);
		List<City> cities= cityController.findCityByState(code);
		Stream<City> cidadesStream = cities.stream().filter(cidade -> cidade.getName().equals(nomeCidade));
		assertEquals(1, cidadesStream.count());
	}
	
	@Test
	void testarPesquisarEstadoPorSigla() {
		
		String uf_CE = "CE";
		State state = stateRepository.findByCode(uf_CE).get();
		assertEquals("Ceará", state.getName());
	}
	@Test
	void testarPesquisarCidadePorNome() {
		String nomeCidade = "Fortaleza";
		CityDTO cityDTO = new CityDTO(nomeCidade,"CE");
		cityController.addCity(cityDTO);
		City city= cityController.findCityByName(nomeCidade);
		assertEquals(nomeCidade, city.getName());
	}
	@Test
	void testarBuscaPorTodasCidadesMaiorQueZero() {
		String nomeCidade = "Florianópolis";
		CityDTO cityDTO = new CityDTO(nomeCidade,"SC");
		cityController.addCity(cityDTO);
		Iterable<City> todasCidades = cityController.listarTodasCidades();
		assertNotEquals(0, ((Collection<?>)todasCidades).size());
	}
	
	
	
}
