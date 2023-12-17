package com.integrador.backend2.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha-post")
    private Date fechaPost;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User usuario;
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria idcategoria;

    public Producto(){ }

}
