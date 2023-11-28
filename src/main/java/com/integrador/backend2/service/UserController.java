package com.integrador.backend2.service;

import com.integrador.backend2.model.User;
import com.integrador.backend2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api_int_2023/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value="store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User store(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PutMapping("update/{id}")
    public User actualizar(@RequestBody User user, @PathVariable("id") Integer id){
        User userDB = userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("El usuario con id: "+id+" no fue encontrado."));
        return userRepository.save(userDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

}
