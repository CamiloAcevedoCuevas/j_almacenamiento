import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.uninorte.BaseDeDatos;

public class TestAlmacenamiento {
    
    @Test
    public void testUnRegistro() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", BaseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals(1, BaseDeDatos.ObtenerNumeroTablas());

        assertEquals(1, BaseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        BaseDeDatos.BorrarTodo();
    
        assertEquals(0, BaseDeDatos.ObtenerNumeroTablas());

        assertEquals(-1, BaseDeDatos.ObtenerNumRegistrosEnTabla(0)); 
    }

    @Test
    public void testMultiplesRegistrosMultiplesTablas() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", BaseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals("001002", BaseDeDatos.AgregarRegistro(Boolean.valueOf(true), Integer.valueOf(1), " mundo"));        

        assertEquals("002001", BaseDeDatos.AgregarRegistro(Boolean.valueOf(true), Double.valueOf(1.5)));

        assertEquals(2, BaseDeDatos.ObtenerNumeroTablas());

        assertEquals(2, BaseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        assertEquals(1, BaseDeDatos.ObtenerNumRegistrosEnTabla(2));

        BaseDeDatos.BorrarTodo();
  
    }

    @Test
    public void testImprimirTablas(){
        
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", BaseDeDatos.AgregarRegistro(Integer.valueOf(0), "Hola "));

        assertEquals("001002", BaseDeDatos.AgregarRegistro(Integer.valueOf(1), " mundo"));

        assertEquals("002001", BaseDeDatos.AgregarRegistro(Double.valueOf(1.5)));
        
        assertEquals("ID: 001001 0 | Hola --- ID: 001002 1 | mundo ----- ID: 002001 1.5", BaseDeDatos.ImprimirTodo());
        
        BaseDeDatos.BorrarTodo();
    }

    @Test
    public void testEditarRegistro() {
 
        // nos aseguramos de que la base de datos esté vacía
        BaseDeDatos.BorrarTodo();

        // almacenamos un registro con estructura Boolean, Integer y String
        // se espera que el índice sea 001001
        // lo que significa que es el primer registro de la primera tabla
        assertEquals("001001", BaseDeDatos.AgregarRegistro(Boolean.valueOf(false), Integer.valueOf(0), "Hola "));

        assertEquals("001002", BaseDeDatos.AgregarRegistro(Boolean.valueOf(true), Integer.valueOf(1), " mundo"));        

        assertEquals("002001", BaseDeDatos.AgregarRegistro(Boolean.valueOf(true), Double.valueOf(1.5)));

        assertEquals(2, BaseDeDatos.ObtenerNumeroTablas());

        assertEquals(2, BaseDeDatos.ObtenerNumRegistrosEnTabla(1)); 

        assertEquals(1, BaseDeDatos.ObtenerNumRegistrosEnTabla(2));

        BaseDeDatos.EditarReg("001001", Boolean.valueOf(true), Integer.valueOf(0), "Hola de nuevo ");

        BaseDeDatos.EditarReg("001002", Boolean.valueOf(false), Integer.valueOf(1), "mundo");

        BaseDeDatos.EditarReg("002001", Boolean.valueOf(false), Double.valueOf(1.5));

        assertEquals("ID: 001001 true | 0 | Hola de nuevo --- ID: 001002 false | 1 | mundo ----- ID: 002001 false | 1.5", BaseDeDatos.ImprimirTodo());

        BaseDeDatos.BorrarTodo();
  
    }
}
