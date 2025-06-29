package com.talentotech.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.ecommerce.model.Articulo;
import com.talentotech.ecommerce.service.IArticuloService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ecommerce/articulos")
public class ArticuloController {

    private final IArticuloService iArticuloService;

    public ArticuloController(IArticuloService iArticuloService) {
        this.iArticuloService = iArticuloService;
    }

    @GetMapping("/listar")
    public List<Articulo> getArticulos() {
        return iArticuloService.listarArticulos();
    }
    
    @GetMapping("/articuloInfo/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        return iArticuloService.obtenerArticulo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("articuloPorCat/{categoria}")
    public List<Articulo> obtenerPorCategoria(@PathVariable String categoria) {
        return iArticuloService.obtenerPorCategoria(categoria);
    }

    @PostMapping("/crearArticulo")
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return iArticuloService.saveArticulo(articulo);
    }

    @PutMapping("editarArticulo/{id}")
    public ResponseEntity<Articulo> editArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (iArticuloService.obtenerArticulo(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(iArticuloService.editarArticulo(id, articulo));
    }

    @DeleteMapping("borrarArticulo/{id}")
    public ResponseEntity<Void> deleteArticulo(@PathVariable Long id) {
        if (iArticuloService.obtenerArticulo(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        iArticuloService.eliminarArticulo(id);

        return ResponseEntity.noContent().build();
    }
}
