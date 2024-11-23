package com.uninorte;

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
        StringBuilder sb = new StringBuilder("ID: ").append(id).append(" ");
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] instanceof String) {
                sb.append(((String) valores[i]).trim());
            } else {
                sb.append(valores[i]);
            }
            if (i < valores.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

}
