package com.example.ejercicio2.controller;

import com.example.ejercicio2.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private Map<String, Producto> productos = new ConcurrentHashMap<>();

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        productos.put(producto.getId(), producto);
        return producto;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String id) {
        Producto producto = productos.get(id);
        return (producto != null) ? ResponseEntity.ok(producto)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto producto) {
        if (productos.containsKey(id)) {
            producto.setId(id);
            productos.put(id, producto);
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        if (productos.containsKey(id)) {
            productos.remove(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}