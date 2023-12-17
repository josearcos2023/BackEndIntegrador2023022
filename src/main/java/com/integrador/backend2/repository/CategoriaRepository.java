package com.integrador.backend2.repository;

import com.integrador.backend2.model.Categoria;
import com.integrador.backend2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
