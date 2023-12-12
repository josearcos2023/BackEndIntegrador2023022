package com.integrador.backend2.repository;

import com.integrador.backend2.model.Categoria;
import com.integrador.backend2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByCategoria(Categoria categoria);
    Optional<Producto> findByIdProducto(Integer idProducto);

}
