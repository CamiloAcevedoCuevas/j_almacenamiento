package com.uninorte;

public class Registro {

    private String id;
    private Object[] valores;

    public Registro(Object... valores) {
        this.valores = valores;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setValores(Object... valores) {
        this.valores = valores;
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        for (Object valor : valores) {
            sb.append(valor).append(" | ");
        }
        return sb.toString().trim();
    }
}
