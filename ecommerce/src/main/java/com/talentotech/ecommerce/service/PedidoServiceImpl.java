package com.talentotech.ecommerce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentotech.ecommerce.model.Articulo;
import com.talentotech.ecommerce.model.Pedido;
import com.talentotech.ecommerce.repository.IArticuloRepository;
import com.talentotech.ecommerce.repository.IPedidoRepository;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository iPedidoRepository;

    @Autowired
    private IArticuloRepository iArticuloRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return iPedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtenerPedido(Long id) {
        return iPedidoRepository.findById(id);
    }

    @Override
    public Pedido crearPedido(List<Long> idsArticulo) {
        // se busca los articulos 
        List<Articulo> articulos = iArticuloRepository.findAllById(idsArticulo);

        if (articulos.isEmpty()) {  // acá se hace una validación por si no encuentra los artículos
            throw new RuntimeException("No existen los artículos con los IDs dados.");
        }

        // Se crea el pedido y se setea
        Pedido pedido = new Pedido();
        pedido.setFecha(LocalDate.now());
        pedido.setArticulos(articulos);

        // Se calcula el total de la suma de los precios y se setea
        double total = articulos.stream().mapToDouble(Articulo::getPrecio).sum();
        pedido.setTotal(total);

        // Se guarda el pedido
        return iPedidoRepository.save(pedido);
    }

}
