package com.uninorte;

import java.util.ArrayList;
import java.util.List;

public class Tabla {

    private List<Registro> registros;
    private static int contadorTabla = 1;  // Contador global para las tablas
    private int contadorRegistros;  // Contador local para los registros dentro de esta tabla

    public Tabla() {
        this.registros = new ArrayList<>();
        this.contadorRegistros = 1;  // La primera tabla comienza con el primer registro
    }

    public String agregarRegistro(Registro registro) {
        // Generamos el ID del registro basándonos en el contador de la tabla y el contador de registros
        String id = String.format("%03d%03d", contadorTabla, contadorRegistros);
        registro.setId(id);
        registros.add(registro);
        contadorRegistros++;  // Incrementamos el contador de registros de la tabla
        return id;
    }

    public int ObtenerNumRegistros() {
        return registros.size();
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        for (Registro registro : registros) {
            sb.append("ID: ").append(registro.getId())
              .append(" ").append(registro.imprimir())
              .append(" --- ");
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

    // Método para incrementar el contador de tablas (se usa en BaseDeDatos)
    public static void incrementarContadorTabla() {
        contadorTabla++;  // Incrementa el contador global solo cuando se crea una nueva tabla
    }

    // Método para obtener el contador de tablas
    public static int getContadorTabla() {
        return contadorTabla;
    }
}
