package com.kata.api.Repository;

import com.kata.api.Model.Beers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beers, Long>{
}
