package com.talentotech.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.talentotech.ecommerce.model.Articulo;
import com.talentotech.ecommerce.repository.IArticuloRepository;

@Service
public class ArticuloService implements IArticuloService{

    // Injección de dependencia mediante un constructor, no se necesita @Autowired
    private final IArticuloRepository artRepository;
    
    public ArticuloService(IArticuloRepository artRepository) {
        this.artRepository = artRepository;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return artRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerArticulo(Long id) {
        return artRepository.findById(id);
    }

    @Override
    public Articulo saveArticulo(Articulo articulo) {
        return artRepository.save(articulo);
    }

    @Override
    public Articulo editarArticulo(Long id, Articulo articulo) {
        articulo.setId(id);
        return artRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id) {
        artRepository.deleteById(id);
    }

    
}
