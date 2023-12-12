package com.integrador.backend2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombre;
    private Float precio;
    private String condicion;
    private String fechaPost;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User usuario;
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;

}
