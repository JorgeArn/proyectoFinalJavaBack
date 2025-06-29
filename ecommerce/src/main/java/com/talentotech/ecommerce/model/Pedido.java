package com.talentotech.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate fecha;
    @Column
    private Double total;
    
    @ManyToMany
    @JoinTable(name = "pedido_articulo",
                joinColumns = @JoinColumn(name = "pedido_id"),
                inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private List<Articulo> articulos;

    // Constructores

    public Pedido() {
    }

    public Pedido(Long id, LocalDate fecha, Double total, List<Articulo> articulos) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.articulos = articulos;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    
}
