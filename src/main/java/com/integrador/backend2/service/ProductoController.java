package com.integrador.backend2.service;

import com.integrador.backend2.model.Producto;
import com.integrador.backend2.model.Producto;
import com.integrador.backend2.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("api_int_2023/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto store(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/getAll")
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @PutMapping("update/{id}")
    public Producto actualizar(@RequestBody Producto producto, @PathVariable("id") Integer id){
        Producto productoDB = productoRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("El producto con id: "+id+" no fue encontrado."));
        return productoRepository.save(productoDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try{
            productoRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

}
