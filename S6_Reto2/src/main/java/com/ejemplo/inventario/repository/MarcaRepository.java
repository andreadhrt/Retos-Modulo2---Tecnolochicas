package com.ejemplo.inventario.repository;

import com.ejemplo.inventario.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
