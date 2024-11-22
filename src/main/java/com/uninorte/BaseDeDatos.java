package com.uninorte;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private static List<Tabla> tablas = new ArrayList<>();

    // Borra todas las tablas y registros
    public static void BorrarTodo() {
        tablas.clear();
    }

    // Agrega un registro a la base de datos
    public static String AgregarRegistro(Object... valores) {
        // Si no hay tablas o la última tabla tiene 2 registros, agregamos una nueva tabla
        if (tablas.isEmpty() || tablas.get(tablas.size() - 1).ObtenerNumRegistros() >= 2) {
            // Creamos una nueva tabla solo si es necesario
            Tabla tabla = new Tabla();
            tablas.add(tabla);
        }

        // Agregar el registro a la última tabla
        Tabla tabla = tablas.get(tablas.size() - 1);
        return tabla.agregarRegistro(new Registro(valores));
    }

    // Obtiene el número de tablas
    public static int ObtenerNumeroTablas() {
        return tablas.size();
    }

    // Obtiene el número de registros en una tabla
    public static int ObtenerNumRegistrosEnTabla(int indice) {
        if (indice < 1 || indice > tablas.size()) {
            return -1;
        }
        return tablas.get(indice - 1).ObtenerNumRegistros();
    }

    // Imprime todos los registros de todas las tablas
    public static String ImprimirTodo() {
        StringBuilder sb = new StringBuilder();
        for (Tabla tabla : tablas) {
            sb.append(tabla.imprimir());
        }
        return sb.toString();
    }

    // Edita un registro en cualquier tabla
    public static void EditarReg(String id, Object... nuevosValores) {
        for (Tabla tabla : tablas) {
            if (tabla.editarRegistro(id, nuevosValores)) {
                break;
            }
        }
    }
}
