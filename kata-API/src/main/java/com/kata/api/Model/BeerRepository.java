package com.kata.api.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beers, Long>{
}
