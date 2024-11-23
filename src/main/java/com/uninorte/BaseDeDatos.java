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
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] instanceof String) {
                valores[i] = ((String) valores[i]).trim();
            }
        }
    
        if (tablas.isEmpty() || tablas.get(tablas.size() - 1).ObtenerNumRegistros() >= 2) {
            Tabla tabla = new Tabla();
            tablas.add(tabla);
        }
    
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
        for (int i = 0; i < tablas.size(); i++) {
            sb.append(tablas.get(i).imprimir().trim()); // Quita espacios en cada tabla
            if (i < tablas.size() - 1) {
                sb.append(" ----- "); // Separador entre tablas
            }
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

