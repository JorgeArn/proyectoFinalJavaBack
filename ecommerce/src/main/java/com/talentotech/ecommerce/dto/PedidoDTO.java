package com.talentotech.ecommerce.dto;

import java.util.List;

public class PedidoDTO {

    private List<Long> idsArticulo;

    public PedidoDTO(List<Long> idsArticulo) {
        this.idsArticulo = idsArticulo;
    }

    public List<Long> getIdsArticulo() {
        return idsArticulo;
    }

    public void setIdsArticulo(List<Long> idsArticulo) {
        this.idsArticulo = idsArticulo;
    }

}
