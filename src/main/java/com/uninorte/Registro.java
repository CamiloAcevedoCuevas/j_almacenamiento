package com.uninorte;

public class Registro {
    private String id;
    private Object[] datos;

    public Registro(String id, Object... datos) {
        this.id = id;
        this.datos = datos;
    }

    public String getId() {
        return id;
    }

    public Object[] getDatos() {
        return datos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDatos(Object[] datos) {
        this.datos = datos;
    }
}