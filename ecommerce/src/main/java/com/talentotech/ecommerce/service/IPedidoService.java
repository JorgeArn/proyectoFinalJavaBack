package com.talentotech.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.talentotech.ecommerce.model.Pedido;

public interface IPedidoService {

    public List<Pedido> listarPedidos();

    public Optional<Pedido> obtenerPedido(Long id);

    public Pedido crearPedido(List<Long> idsArticulo);

}
