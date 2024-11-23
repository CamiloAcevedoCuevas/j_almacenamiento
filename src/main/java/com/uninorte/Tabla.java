package com.uninorte;

import java.util.ArrayList;
import java.util.List;

public class Tabla {
    private static int contadorTablas = 1; // Contador estático para las tablas
    private int idTabla; // ID único para esta tabla
    private int contadorRegistros; // Contador de registros dentro de esta tabla
    private List<Registro> registros;

    public Tabla() {
        this.idTabla = contadorTablas++;
        this.contadorRegistros = 1;
        this.registros = new ArrayList<>();
    }

    public static void incrementarContadorTabla() {
        contadorTablas++;
    }

    public static void resetearContadorTabla() {
        contadorTablas = 1;
    }

    public String agregarRegistro(Object... valores) {
        String idRegistro = String.format("%03d%03d", idTabla, contadorRegistros++);
        registros.add(new Registro(idRegistro, valores));
        return idRegistro;
    }

    public int ObtenerNumRegistros() {
        return registros.size();
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < registros.size(); i++) {
            Registro registro = registros.get(i);
            sb.append(registro.toString());
            if (i < registros.size() - 1) {
                sb.append(" --- "); // Solo agregar separador si no es el último registro
            }
        }
        return sb.toString();
    }     

    public boolean editarRegistro(String id, Object... nuevosValores) {
        for (Registro registro : registros) {
            if (registro.getId().equals(id)) {
                registro.setValores(nuevosValores);
                return true;
            }
        }
        return false;
    }

}
