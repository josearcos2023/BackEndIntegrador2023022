package com.integrador.backend2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;

    @ManyToOne
    @JoinColumn(name = "idComprador")
    private User comprador;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private User vendedor;

    private Date fechaVenta;
    private Float precioTransaccion;
    private String estado;

}
