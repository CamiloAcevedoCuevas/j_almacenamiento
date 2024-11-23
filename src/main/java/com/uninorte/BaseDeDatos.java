package com.uninorte;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    private static List<Tabla> tablas = new ArrayList<>();

    // Método público para agregar un registro con parámetros variables
    public static String AgregarRegistro(Object... datos) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] instanceof String) {
                datos[i] = ((String) datos[i]).trim();
            }
        }
    
        if (tablas.isEmpty() || tablas.get(tablas.size() - 1).ObtenerNumRegistros() >= 2) {
            Tabla tabla = new Tabla();
            tablas.add(tabla);
        }
    
        Tabla tabla = tablas.get(tablas.size() - 1);
        return tabla.agregarRegistro(datos);
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

    public static void BorrarTodo() {
        tablas.clear();
        Tabla.resetearContadorTabla(); // Resetear el contador de tablas
    }
  
    public static void EditarReg(String recordId, Object... newValues) {
        for (Tabla tabla : tablas) {
            if (tabla.editarRegistro(recordId, newValues)) {
                break;
            }
        }
    }

    public static boolean BorrarReg(String recordId) {
       
        return false;
    }

    
    public static int ObtenerNumRegistrosEnTabla(int i) {
        if (i < 1 || i > tablas.size()) {
            return -1;
        }
        return tablas.get(i - 1).ObtenerNumRegistros();
    }
    
    public static Integer ObtenerNumeroTablas() {
        return tablas.size();
    }
    
}