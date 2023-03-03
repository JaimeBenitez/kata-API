package com.kata.api.Controller;

import com.kata.api.Model.Categories;
import com.kata.api.Repository.CategoryRepository;
import com.kata.api.errors.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    /**
     * Obtenemos todas las categorias
     *
     * @return lista de categorias
     */
    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
        return categoryRepository.findAll();
    }

    /**
     * Obtenemos una categoria en base a su ID
     *
     * @param id
     * @return Error 404 si no encuentra la categoria
     */
    @GetMapping("category/{id}")
    public Categories getCategoryById(@PathVariable Long id){

        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
