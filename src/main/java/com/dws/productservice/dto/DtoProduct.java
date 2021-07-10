package com.dws.productservice.dto;

import java.time.LocalDate;

public class DtoProduct {

    private int id;
    private String codigo;
    private String producto;
    private String descripcion;
    private double precio;
    private int cantidad;
    private LocalDate fecha_creacion;
    private int id_categoria;

    public DtoProduct() {
        super();
    }

    public DtoProduct(int id, String codigo, String producto, String descripcion, double precio, int cantidad,
                      LocalDate fecha_creacion, int id_categoria) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha_creacion = fecha_creacion;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "DtoProduct [id=" + id + ", codigo=" + codigo + ", producto=" + producto + ", descripcion=" + descripcion
            + ", precio=" + precio + ", cantidad=" + cantidad + ", fecha_creacion=" + fecha_creacion
            + ", id_categoria=" + id_categoria + "]";
    }

}
