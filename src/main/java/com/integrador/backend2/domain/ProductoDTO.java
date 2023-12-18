package com.integrador.backend2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO {

    private Integer idProducto;
    private String nombre;
    private Float precio;
    private String condicion;
    private Date fechaPost;
    private Integer usuario;
    private Integer idcategoria;

}
