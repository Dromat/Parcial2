package com.example.ejercicio5;

import com.example.ejercicio5.controller.ProductoController;
import com.example.ejercicio5.model.Producto;
import com.example.ejercicio5.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@AutoConfigureWebTestClient
public class Ejercicio5ApplicationTests {

	private final ProductoController productoController =
			new ProductoController(new ProductoService());

	@Test
	public void testListaProductos() {
		Flux<Producto> productos = productoController.listarProductos();

		StepVerifier.create(productos)
				.expectNextMatches(p -> p.getNombre().equals("Laptop"))
				.expectNextMatches(p -> p.getNombre().equals("Mouse"))
				.expectNextMatches(p -> p.getNombre().equals("Teclado"))
				.verifyComplete();
	}
}
