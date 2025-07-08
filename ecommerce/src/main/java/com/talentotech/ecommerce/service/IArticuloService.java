package com.talentotech.ecommerce.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.talentotech.ecommerce.model.Articulo;

public interface IArticuloService {

    // Lista todos los artículos
    public List<Articulo> listarArticulos();

    // Obtiene un artículo por su ID
    public Optional<Articulo> obtenerArticulo(Long id);

    // Lista todos los artículos de una categoria
    public List<Articulo> obtenerPorCategoria(String categoria);

    // Crea un artículo
    public Articulo crearArticulo(String nombre, Double precio, String categoria, MultipartFile imagen) throws IOException;

    // Edita un artículo mediante el id que se pasa por parámetro
    public Articulo editarArticulo(Long id, String nombre, Double precio, String categoria, MultipartFile imagen) throws IOException;

    // Elimina un artículo
    public void eliminarArticulo(Long id);
    
}
