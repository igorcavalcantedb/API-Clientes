package com.compasso.recrutamento;

import com.compasso.recrutamento.controller.CidadeController;
import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.entity.Cliente;
import com.compasso.recrutamento.entity.Estado;
import com.compasso.recrutamento.repository.EstadoRepository;
import com.compasso.recrutamento.service.EstadoService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class RecrutamentoApplicationTests {
@Autowired
EstadoRepository estadoRepository;
	@Test
	void contextLoads() {
		
		
	}
	
}
