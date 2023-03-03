package com.kata.api.Repository;

import com.kata.api.Model.Breweries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Breweries, Long> {
}
