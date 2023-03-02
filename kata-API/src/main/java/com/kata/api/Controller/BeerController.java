package com.kata.api.Controller;

import com.kata.api.Model.Beers;
import com.kata.api.Model.BeerRepository;
import errors.BeerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerRepository beerRepository;

    /**
     * Obtenemos todas las cervezas
     *
     * @return lista de cervezas
     */
    @GetMapping("/beers")
    public ResponseEntity<List<Beers>> getAllBeers(){
        List<Beers> beers = beerRepository.findAll();
        if(beers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(beers);
        }
    }

    /**
     * Obtenemos una cerveza en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la cerveza
     */
    @GetMapping("beer/{id}")
    public Beers getBeerById(@PathVariable Long id){

        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    /**
     * Eliminamos una cerveza en base a su ID
     *
     * @param id
     * @return Código 204 sin contenido
     */
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Void> deleteBeerById(@PathVariable Long id){
            Beers beer = beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
            beerRepository.delete(beer);
            return ResponseEntity.noContent().build();
    }

    /**
     * Creamos una nueva cerveza
     *
     * @param newBeer
     * @return cerveza insertada
     */
    @PostMapping("/beer")
    public Beers newBeer(@RequestBody Beers newBeer){
        newBeer.setLast_mod(LocalDateTime.now());
        return beerRepository.save(newBeer);
    }

    /**
     * Actualizamos una cerveza
     *
     * @param newBeer
     * @param id
     * @return cerveza actualizada, 404 si no se encuentra la cerveza
     */
    @PutMapping("/beer/{id}")
    public Beers updateBeer(@RequestBody Beers newBeer, @PathVariable Long id) {
        return beerRepository.findById(id).map(b -> {
            b.setId(newBeer.getId());
            b.setName(newBeer.getName());
            b.setAbv(newBeer.getAbv());
            b.setIbu(newBeer.getIbu());
            b.setSrm(newBeer.getSrm());
            b.setUpc(newBeer.getUpc());
            b.setFilepath(newBeer.getFilepath());
            b.setDescript(newBeer.getDescript());
            b.setAdd_user(newBeer.getAdd_user());
            b.setLast_mod(LocalDateTime.now());
            return beerRepository.save(b);
        }).orElseThrow(() -> new BeerNotFoundException(id));
    }
}
