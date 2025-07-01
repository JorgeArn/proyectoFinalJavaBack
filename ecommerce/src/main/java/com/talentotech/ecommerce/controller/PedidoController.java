package com.talentotech.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.ecommerce.dto.PedidoDTO;
import com.talentotech.ecommerce.model.Pedido;
import com.talentotech.ecommerce.service.IPedidoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ecommerce/pedidos")
public class PedidoController {

    private final IPedidoService iPedidoService;

    public PedidoController(IPedidoService iPedidoService) {
        this.iPedidoService = iPedidoService;
    }

    @GetMapping("/listar")
    public List<Pedido> traerPedidos() {
        return iPedidoService.listarPedidos();
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Pedido> pedidoPorId(@PathVariable Long id) {
        return iPedidoService.obtenerPedido(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = iPedidoService.crearPedido(pedidoDTO.getIdsArticulo());
        return ResponseEntity.ok(pedido);
    }
}
