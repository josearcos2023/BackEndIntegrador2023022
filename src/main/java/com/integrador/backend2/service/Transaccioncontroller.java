package com.integrador.backend2.service;

import com.integrador.backend2.model.Transaccion;
import com.integrador.backend2.repository.TransaccionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api_int_2023/transacciones")
public class Transaccioncontroller {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Transaccion store(@RequestBody Transaccion transaccion){
        return transaccionRepository.save(transaccion);
    }

    @GetMapping("/getAll")
    public List<Transaccion> getAll() {
        return transaccionRepository.findAll();
    }

    @PutMapping("update/{id}")
    public Transaccion actualizar(@RequestBody Transaccion transaccion, @PathVariable("id") Integer id){
        Transaccion transaccionDB = transaccionRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("La categoría con id: "+id+" no fue encontrado."));
        return transaccionRepository.save(transaccionDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try{
            transaccionRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

}
