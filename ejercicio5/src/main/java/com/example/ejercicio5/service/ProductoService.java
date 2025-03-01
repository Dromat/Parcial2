package com.example.ejercicio5.service;

import com.example.ejercicio5.model.Producto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductoService {
    public Flux<Producto> obtenerProductos() {
        return Flux.just(
                new Producto("1", "Laptop", 1200.0),
                new Producto("2", "Mouse", 25.0),
                new Producto("3", "Teclado", 45.0)
        );
    }
}
