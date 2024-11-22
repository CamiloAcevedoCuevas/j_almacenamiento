package com.uninorte;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private static List<Tabla> tablas = new ArrayList<>();

    public static void BorrarTodo() {
        tablas.clear();
        Tabla.resetearContadorTabla(); // Resetear el contador de tablas
    }

    public static String AgregarRegistro(Object... valores) {
        // Si no hay tablas o la última tabla tiene 2 registros, agregar una nueva tabla
        if (tablas.isEmpty() || tablas.get(tablas.size() - 1).ObtenerNumRegistros() >= 2) {
            Tabla tabla = new Tabla(); // Crear nueva tabla
            tablas.add(tabla);
        }

        // Agregar el registro a la última tabla
        Tabla tabla = tablas.get(tablas.size() - 1);
        return tabla.agregarRegistro(valores);
    }

    public static int ObtenerNumeroTablas() {
        return tablas.size();
    }

    public static int ObtenerNumRegistrosEnTabla(int indice) {
        if (indice < 1 || indice > tablas.size()) {
            return -1;
        }
        return tablas.get(indice - 1).ObtenerNumRegistros();
    }

    public static String ImprimirTodo() {
        StringBuilder sb = new StringBuilder();
        for (Tabla tabla : tablas) {
            sb.append(tabla.imprimir());
        }
        return sb.toString();
    }

    public static void EditarReg(String id, Object... nuevosValores) {
        for (Tabla tabla : tablas) {
            if (tabla.editarRegistro(id, nuevosValores)) {
                break;
            }
        }
    }
}

