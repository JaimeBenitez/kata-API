package com.kata.api.Controller;

import com.kata.api.Model.StyleRepository;
import com.kata.api.Model.Styles;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StylesController {

    private final StyleRepository styleRepository;

    /**
     * Obtenemos todos los estilos
     *
     * @return lista de estilos
     */
    @GetMapping("/styles")
    public List<Styles> getAllStyles(){
        return styleRepository.findAll();
    }

    /**
     * Obtenemos un estilo en base a su ID
     *
     * @param id
     * @return Null si no encuentra el estilo
     */
    @GetMapping("style/{id}")
    public Styles getStyleById(@PathVariable Long id){
        return styleRepository.findById(id).orElse(null);
    }
}
