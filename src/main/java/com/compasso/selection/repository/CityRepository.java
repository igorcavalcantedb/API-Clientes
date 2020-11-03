package com.compasso.selection.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.compasso.selection.entity.City;
import com.compasso.selection.entity.State;

public interface CityRepository extends PagingAndSortingRepository<City,Long> {

	City findByName(String city);

	List<City> findByState(State state);
}
