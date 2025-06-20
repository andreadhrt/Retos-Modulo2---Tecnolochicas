package com.ejemplo.inventario;

import com.ejemplo.inventario.model.Marca;
import com.ejemplo.inventario.model.Producto;
import com.ejemplo.inventario.repository.MarcaRepository;
import com.ejemplo.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            // Crear marcas
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            // Crear productos asociados a marcas
            productoRepo.save(new Producto("iPhone 15", "Smartphone de Apple", 24000f, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet de Apple", 18000f, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone Samsung", 20000f, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisor 4K Samsung", 10000f, samsung));

            // Mostrar productos agrupados por marca
            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
