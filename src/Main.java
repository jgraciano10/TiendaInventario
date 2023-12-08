import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcionSeleccionada = opcionesUsuario.mostrarOpciones();
        actions.accionesSobreInventario(opcionSeleccionada);
        //System.out.println(connectorClase.obtenerProductos(conector));



    }
}