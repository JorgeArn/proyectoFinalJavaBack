package com.talentotech.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.ecommerce.model.Articulo;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo, Long> {

    // Método que trae todos los artículos por categoría
    List<Articulo> findByCategoria(String categoria);
}
