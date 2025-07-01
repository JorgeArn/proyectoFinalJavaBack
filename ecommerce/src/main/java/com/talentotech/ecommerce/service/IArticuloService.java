package com.talentotech.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.talentotech.ecommerce.model.Articulo;

public interface IArticuloService {

    // Lista todos los artículos
    public List<Articulo> listarArticulos();

    // Obtiene un artículo por su ID
    public Optional<Articulo> obtenerArticulo(Long id);

    // Crea un artículo
    public Articulo saveArticulo(Articulo articulo);

    // Edita un artículo mediante el id que se pasa por parámetro
    public Articulo editarArticulo(Long id, Articulo articulo);

    // Elimina un artículo
    public void eliminarArticulo(Long id);
    
}
