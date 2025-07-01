package com.talentotech.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.ecommerce.model.Articulo;

@Repository
public interface IArticuloRepository extends JpaRepository<Articulo, Long> {

    
}
