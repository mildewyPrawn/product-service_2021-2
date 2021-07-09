package com.dws.productservice.dto;

public class DtoCategory {

    private int id;
    private String categoria;

    public DtoCategory() {
        super();
    }

    public DtoCategory(int id, String categoria) {
        super();
        this.id = id;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "DtoCategory [id=" + id + ", categoria=" + categoria + "]";
    }

}
