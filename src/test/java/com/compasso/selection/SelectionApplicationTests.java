package com.compasso.selection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.DTO.ClientDTO;
import com.compasso.selection.controller.CityController;
import com.compasso.selection.controller.ClientController;
import com.compasso.selection.entity.City;
import com.compasso.selection.entity.State;
import com.compasso.selection.enums.Gender;
import com.compasso.selection.exceptions.CityAlreadyExistsException;
import com.compasso.selection.exceptions.StateNotFoundException;
import com.compasso.selection.repository.StateRepository;
import com.compasso.selection.utils.NameValidator;


@SpringBootTest
class SelectionApplicationTests {
@Autowired
StateRepository stateRepository;
@Autowired
CityController cityController;
@Autowired
ClientController clientController;	

		
	/*@Test
	void cadastrarCidade() throws CityAlreadyExistsException, StateNotFoundException {
		String nomeCidade = "Itajaí";
		CityDTO cityDTO = new CityDTO(nomeCidade,"SC");
		int statusCode = cityController.addCity(cityDTO).getStatusCodeValue();
		assertEquals(200,statusCode);
	}
	@Test
	void cadastrarCliente() throws DateTimeParseException, Exception {
		ClientDTO clientDTO = new ClientDTO( "Igor Cavalcante",Gender.MALE,"1986-10-23",34,"Fortaleza");
		int statusCode = clientController.addClient(clientDTO).getStatusCodeValue();
		assertEquals(200,statusCode);
	}
	@Test
	void pesquisarCidadePorNome() throws CityAlreadyExistsException, StateNotFoundException {
		String nomeCidade = "Fortaleza";
		CityDTO cityDTO = new CityDTO(nomeCidade,"CE");
		cityController.addCity(cityDTO);
		City city= cityController.findCityByName(nomeCidade);
		assertEquals(nomeCidade, city.getName());
	}
	@Test
	void pesquisarCidadePorEstado() throws CityAlreadyExistsException, StateNotFoundException {
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
	void testarPesquisarCidadePorNome() throws CityAlreadyExistsException, StateNotFoundException {
		String nomeCidade = "Fortaleza";
		CityDTO cityDTO = new CityDTO(nomeCidade,"CE");
		cityController.addCity(cityDTO);
		City city= cityController.findCityByName(nomeCidade);
		assertEquals(nomeCidade, city.getName());
	}
	@Test
	void testarBuscaPorTodasCidadesMaiorQueZero() throws CityAlreadyExistsException, StateNotFoundException {
		String nomeCidade = "Florianópolis";
		CityDTO cityDTO = new CityDTO(nomeCidade,"SC");
		cityController.addCity(cityDTO);
		Iterable<City> todasCidades = cityController.listarTodasCidades();
		assertNotEquals(0, ((Collection<?>)todasCidades).size());
	}*/
	@Test
	void nameValidTest() {
		
		boolean resp = NameValidator.isNameValid("32423sdfsdf");
		assertEquals(false, resp);
	}
	
	@Test
	void addClientTest() {
		ClientDTO clientDTO = new ClientDTO("#@$ds89fsf", Gender.MALE, "2022-10-10",3, "Itajaí");
		try {
			clientController.addClient(clientDTO);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			assertEquals(false, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals(true, true);
		}
	}
	
	@Test
	void deleteClientNoExist() {
		int statusCode = clientController.deleteClient(23423L).getStatusCodeValue();
		assertNotEquals(200, statusCode);
	}
	
	
	
}
