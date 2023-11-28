package com.integrador.backend2.repository;

import com.integrador.backend2.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {

}
