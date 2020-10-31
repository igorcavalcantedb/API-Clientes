package com.compasso.selection.repository;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.compasso.selection.entity.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

	Optional<Client> findByName(String name);
}
