package com.talentotech.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.ecommerce.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long>{

}
