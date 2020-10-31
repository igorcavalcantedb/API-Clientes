package com.compasso.recrutamento.repository;

import com.compasso.recrutamento.entity.Cidade;
import com.compasso.recrutamento.entity.Estado;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CidadeRepository extends PagingAndSortingRepository<Cidade,Long> {

	Cidade findByNome(String cidade);

	List<Cidade> findByEstado(Estado estado);
}
