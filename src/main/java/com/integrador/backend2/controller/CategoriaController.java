package com.integrador.backend2.controller;

import com.integrador.backend2.model.Categoria;
import com.integrador.backend2.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api_int_2023/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria store(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/getAll")
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @PutMapping("update/{id}")
    public Categoria actualizar(@RequestBody Categoria categoria, @PathVariable("id") Integer id){
        Categoria categoriaDB = categoriaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("La categoría con id: "+id+" no fue encontrado."));
        categoriaDB.setNombre(categoria.getNombre());
        categoriaDB.setDescripcion(categoria.getDescripcion());
        categoriaDB.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try{
            categoriaRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }
}
