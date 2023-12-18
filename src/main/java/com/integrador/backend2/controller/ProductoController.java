package com.integrador.backend2.controller;

import com.integrador.backend2.domain.ProductoTO;
import com.integrador.backend2.model.Categoria;
import com.integrador.backend2.model.Producto;
import com.integrador.backend2.model.User;
import com.integrador.backend2.repository.CategoriaRepository;
import com.integrador.backend2.repository.ProductoRepository;
import com.integrador.backend2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api_int_2023/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto store(@RequestBody ProductoTO productoTo) {
        Integer idcategoria = productoTo.getIdcategoria();
        Categoria categoria = categoriaRepository.findById(idcategoria)
                .orElseThrow(() -> new RuntimeException("Categoria encontrada con id: " + idcategoria));

        Integer idusuario = productoTo.getUsuario();
        User usuario = userRepository.findById(idusuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idusuario));

        Producto producto = new Producto();
        producto.setNombre(productoTo.getNombre());
        producto.setPrecio(productoTo.getPrecio());
        producto.setCondicion(productoTo.getCondicion());
        producto.setFechaPost(new Date());
        producto.setUsuario(usuario);
        producto.setIdcategoria(categoria);

        return productoRepository.save(producto);
    }

    @GetMapping("/getAll")
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @PutMapping("update/{id}")
    public Producto actualizar(@RequestBody Producto producto, @PathVariable("id") Integer id){
        Producto productoDB = productoRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("El producto con id: "+id+" no fue encontrado."));
        return productoRepository.save(productoDB);
    }

    @DeleteMapping("/delete/{id}")
    public boolean eliminar(@PathVariable("id") Integer id){
        try{
            productoRepository.deleteById(id);
            return true;
        } catch (Exception err){
            return false;
        }
    }

    @GetMapping("/getByIdCategoria/{idCategoria}")
    public List<Producto> getByIdCategoria(@PathVariable ("idCategoria") Categoria idCategoria){

        return productoRepository.findProductoByIdcategoria(idCategoria);
    }

    @GetMapping("/getByIdProducto/{idProducto}")
    public List<Producto> getByIdProducto(@PathVariable ("idProducto") Integer idProducto){
        return productoRepository.findProductoByIdProducto(idProducto);
    }
}
