package com.compasso.recrutamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.repository.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	EstadoRepository estadoRepository;

	public Iterable<Cidade> listarCidadesPorEstado(String uf) {
		// TODO Auto-generated method stub
		estadoRepository.findBySigla(uf);
		return null;
	}
	

}
