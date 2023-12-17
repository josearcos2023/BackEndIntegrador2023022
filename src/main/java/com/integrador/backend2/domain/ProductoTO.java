package com.integrador.backend2.domain;

import com.integrador.backend2.model.Categoria;
import com.integrador.backend2.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoTO {

    private Integer idProducto;
    private String nombre;
    private Float precio;
    private String condicion;
    private Date fechaPost;
    private Integer usuario;
    private Integer idcategoria;

}
