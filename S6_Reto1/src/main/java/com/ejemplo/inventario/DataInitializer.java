package com.ejemplo.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Bean
    CommandLineRunner initData(ProductoRepository repo) {
        return args -> {
            repo.save(new Producto("Laptop Lenovo", "Portátil gama alta", 12500));
            repo.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 350));
            repo.save(new Producto("Teclado Mecánico", "RGB switches azules", 950));
            repo.save(new Producto("Monitor", "24 pulgadas Full HD", 3200));

            System.out.println("\n📦 Productos con precio mayor a 500:");
            repo.findByPrecioGreaterThan(500).forEach(System.out::println);

            System.out.println("\n🔍 Productos que contienen 'lap':");
            repo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

            System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
            repo.findByPrecioBetween(400, 1000).forEach(System.out::println);

            System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
            repo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}
