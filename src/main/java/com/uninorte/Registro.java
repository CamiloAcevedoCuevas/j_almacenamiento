package com.uninorte;

import java.util.Arrays;

public class Registro {
    private String id;
    private Object[] valores;

    public Registro(String id, Object... valores) {
        this.id = id;
        this.valores = valores;
    }

    public String getId() {
        return id;
    }

    public Object[] getValores() {
        return valores;
    }

    public void setValores(Object... valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return id + " -> " + Arrays.toString(valores);
    }
}

