package com.compasso.recrutamento.repository;


import com.compasso.recrutamento.entity.Cliente;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	Optional<Cliente> findByNome(String nome);
}
