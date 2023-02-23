package com.kata.api.Controller;

import com.kata.api.Model.Beers;
import com.kata.api.Model.BeerRepository;
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
     * @return Null si no encuentra la cerveza
     */
    @GetMapping("beer/{id}")
    public Beers getBeerById(@PathVariable Long id){
        Optional<Beers> beer = beerRepository.findById(id);
        if(beer.isPresent()){
            return beer.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveza con ID" + id + " no encontrada");
        }
    }

    /**
     * Eliminamos una cerveza en base a su ID
     *
     * @param id
     * @return cerveza eliminada
     */
    @DeleteMapping("/beer/{id}")
    public Beers deleteBeerById(@PathVariable Long id){
        if(beerRepository.existsById(id)){
            Beers beer = beerRepository.findById(id).orElse(null);
            beerRepository.deleteById(id);
            return beer;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveza con ID" + id + " no encontrada, no pudo ser eliminada");
        }
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
     * @return cerveza actualizada
     */
    @PutMapping("/beer/{id}")
    public Beers updateBeer(@RequestBody Beers newBeer, @PathVariable Long id){
        if(beerRepository.existsById(id)){
            newBeer.setId(id);
            newBeer.setLast_mod(LocalDateTime.now());
            return beerRepository.save(newBeer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveza con ID" + id + " no encontrada, no pudo ser actualizada");
        }
    }

    /**
     * Modificar parcialmente una cerveza
     *
     * @param newBeer
     * @param id
     * @return cerveza actualizada
     */
    @PatchMapping("/beer/{id}")
    public Beers patchBeer(@RequestBody Beers newBeer, @PathVariable Long id){
        if(beerRepository.existsById(id)){
            Beers beer = beerRepository.findById(id).orElse(null);
            if(newBeer.getBreweryId() != null){
                beer.setBreweryId(newBeer.getBreweryId());
            }
            if(newBeer.getName() != null){
                beer.setName(newBeer.getName());
            }
            if(newBeer.getCat_id() != null){
                beer.setCat_id(newBeer.getCat_id());
            }
            if(newBeer.getStyle_id() != null){
                beer.setStyle_id(newBeer.getStyle_id());
            }
            if(newBeer.getAbv() != 0){
                beer.setAbv(newBeer.getAbv());
            }
            if(newBeer.getIbu() != 0){
                beer.setIbu(newBeer.getIbu());
            }
            if(newBeer.getSrm() != 0){
                beer.setSrm(newBeer.getSrm());
            }
            if(newBeer.getUpc() != 0){
                beer.setUpc(newBeer.getUpc());
            }
            if(newBeer.getFilepath() != null){
                beer.setFilepath(newBeer.getFilepath());
            }
            if(newBeer.getDescript() != null){
                beer.setDescript(newBeer.getDescript());
            }
            if(newBeer.getAdd_user() != null){
                beer.setAdd_user(newBeer.getAdd_user());
            }
            beer.setLast_mod(LocalDateTime.now());
            return beerRepository.save(beer);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cerveza con ID" + id + " no encontrada, no pudo ser actualizada");
        }
    }
}
