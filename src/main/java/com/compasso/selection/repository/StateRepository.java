package com.compasso.selection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.selection.entity.State;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Long> {
    Optional<State> findByCode(String code);

}
