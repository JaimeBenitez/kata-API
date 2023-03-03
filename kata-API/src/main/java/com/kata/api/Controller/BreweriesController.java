package com.kata.api.Controller;

import com.kata.api.Repository.BreweryRepository;
import com.kata.api.Model.Breweries;
import com.kata.api.errors.BrewerieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BreweriesController {

    private final BreweryRepository breweryRepository;

    /**
     * Obtenemos todas las cervecerias
     *
     * @return lista de cervecerias
     */
    @GetMapping("/breweries")
    public List<Breweries> getAllBreweries(){
        return breweryRepository.findAll();
    }

    /**
     * Obtenemos una cerveceria en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la cerveceria
     */
    @GetMapping("brewery/{id}")
    public Breweries getBreweryById(@PathVariable Long id){

        return breweryRepository.findById(id).orElseThrow(() -> new BrewerieNotFoundException(id));
    }
}
