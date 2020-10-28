package com.compasso.recrutamento.service;

import com.compasso.recrutamento.DTO.ClienteDTO;
import com.compasso.recrutamento.entity.Cliente;
import com.compasso.recrutamento.repository.CidadeRepository;
import com.compasso.recrutamento.repository.ClienteRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.compasso.recrutamento.entity.Cidade;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	public void cadastrarCliente(ClienteDTO clienteDTO) {
		Cidade cidade = cidadeRepository.findByNome(clienteDTO.getCidade());
		Cliente cliente = new Cliente(clienteDTO, cidade);
		clienteRepository.save(cliente);
	}

	public Optional<Cliente> pesquisarPorNome(String nome) {
		Optional<Cliente> cliente = clienteRepository.findByNome(nome);
		return cliente;

	}

	public Optional<Cliente> pesquisaClientePorID(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	public void deletarClientePorId(Long id) {
		clienteRepository.deleteById(id);
		
	}

	public Optional<Cliente> findById(long id) {
		return clienteRepository.findById(id);
		
	}
}
