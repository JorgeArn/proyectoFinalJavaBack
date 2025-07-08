package com.talentotech.ecommerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Articulo> obtenerPorCategoria(String categoria) {
        return artRepository.findByCategoria(categoria);
    }

    @Override
    public Articulo crearArticulo(String nombre, Double precio, String categoria, MultipartFile imagen) throws IOException {
        Articulo articulo = new Articulo();
        articulo.setNombre(nombre);
        articulo.setPrecio(precio);
        articulo.setCategoria(categoria);

        if (imagen != null && !imagen.isEmpty()) {
            // Se crea la carpeta si no existe
            Files.createDirectories(Paths.get("uploads"));

            // Se guarda el archivo
            String nombreArchivo = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Path ruta = Paths.get("uploads").resolve(nombreArchivo);
            Files.copy(imagen.getInputStream(), ruta);

            // Genera la URL
            String url = "http://localhost:8080/uploads/" + nombreArchivo;

            articulo.setImagen(url);
        }

        return artRepository.save(articulo);
    }

    @Override
    public Articulo editarArticulo(Long id, String nombre, Double precio, String categoria, MultipartFile imagen) throws IOException {
        Articulo articulo = artRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        
        articulo.setNombre(nombre);
        articulo.setPrecio(precio);
        articulo.setCategoria(categoria);

        if (imagen != null && !imagen.isEmpty()) {
            // Elimina imagen anterior si existe
            String imagenActual = articulo.getImagen();
            if (imagenActual != null && imagenActual.startsWith("http://localhost:8080/uploads/")) {
                String nombreArchivoViejo = imagenActual.replace("http://localhost:8080/uploads/", "");
                Path rutaVieja = Paths.get("uploads").resolve(nombreArchivoViejo);
                Files.deleteIfExists(rutaVieja);
            }

            // Guarda la nueva imagen
            Files.createDirectories(Paths.get("uploads"));
            String nombreArchivoNuevo = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Path rutaNueva = Paths.get("uploads").resolve(nombreArchivoNuevo);
            Files.copy(imagen.getInputStream(), rutaNueva);

            // Setea la nueva URL
            String url = "http://localhost:8080/uploads/" + nombreArchivoNuevo;
            articulo.setImagen(url);
        }

        return artRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id) {
       Articulo articulo = artRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

        // Elimina la imagen del disco si existe
        String imagen = articulo.getImagen();
        if (imagen != null && imagen.startsWith("http://localhost:8080/uploads/")) {
            String nombreArchivo = imagen.replace("http://localhost:8080/uploads/", "");
            Path rutaImagen = Paths.get("uploads").resolve(nombreArchivo);
            try {
                Files.deleteIfExists(rutaImagen);
            } catch (IOException e) {
               System.err.println("No se pudo eliminar la imagen: " + rutaImagen + "→" + e.getMessage());
            }
            
        }

        // Elimina de la base de datos
        artRepository.deleteById(id);
    }
   
}
