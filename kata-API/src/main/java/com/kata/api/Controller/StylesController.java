package com.kata.api.Controller;


import com.kata.api.Repository.CategoryRepository;
import com.kata.api.Repository.StyleRepository;
import com.kata.api.Model.Styles;
import com.kata.api.dto.StyleDTO;
import com.kata.api.dto.converter.StyleDTOConverter;
import com.kata.api.errors.StyleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StylesController {

    private final StyleRepository styleRepository;
    private final CategoryRepository categoryRepository;
    private final StyleDTOConverter styleDTOConverter;


    /**
     * Obtenemos todos los estilos
     *
     * @return lista de estilos
     */
    @GetMapping("/styles")
    public ResponseEntity<List<?>> getAllStyles(){

        List<Styles> styles = styleRepository.findAll();
        if(styles.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            List<StyleDTO> dtoList =
                    styles.stream().map(styleDTOConverter::convertToDTO).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }

    }

    /**
     * Obtenemos un estilo en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra el estilo
     */
    @GetMapping("style/{id}")
    public Styles getStyleById(@PathVariable Long id){

        return styleRepository.findById(id).orElseThrow(() -> new StyleNotFoundException(id));
    }
}
