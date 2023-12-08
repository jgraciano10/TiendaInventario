import java.sql.Connection;
import java.util.Scanner;

public class actions {

    public static void accionesSobreInventario(int accion){
        conexion connectorClase = new conexion();
        Connection conector = connectorClase.getConexion();

        switch (accion){
            case 1:
                System.out.println("");
                connectorClase.obtenerProductos(conector);
                System.out.println("");
                int opcionSeleccionada = opcionesUsuario.mostrarOpciones();
                actions.accionesSobreInventario(opcionSeleccionada);
                break;
            case 2:
                System.out.println("");

                System.out.println("Ingrese el nombre del producto que desea registrar");
                Scanner input = new Scanner(System.in);
                String nombre = input.nextLine();

                System.out.println("Ingrese el precio del producto que desea registrar");
                int precio = input.nextInt();
                producto productoIngresar = new producto(nombre, precio);
                connectorClase.insertarProducto(conector, productoIngresar);

                System.out.println("");

                int opcionSeleccionada1 = opcionesUsuario.mostrarOpciones();
                actions.accionesSobreInventario(opcionSeleccionada1);

                break;
            case 3:
                System.out.println("");

                System.out.println("Ingrese el nombre del producto al que le desea actualizar el precio");
                Scanner input1 = new Scanner(System.in);
                String nombre1 = input1.nextLine();

                System.out.println("Ingrese el nuevo precio");
                int precio1 = input1.nextInt();
                connectorClase.actualizarProducto(conector, precio1, nombre1);
                System.out.println("");

                int opcionSeleccionada2 = opcionesUsuario.mostrarOpciones();
                actions.accionesSobreInventario(opcionSeleccionada2);
                break;
            case 4:
                System.out.println("");

                System.out.println("Ingrese el nombre del producto que desea eliminar");
                Scanner input2 = new Scanner(System.in);
                String nombre2 = input2.nextLine();
                connectorClase.eliminarProducto(conector, nombre2);

                System.out.println("");

                int opcionSeleccionada3 = opcionesUsuario.mostrarOpciones();
                actions.accionesSobreInventario(opcionSeleccionada3);
                break;
            case 5:
                System.out.println("Programa finalizado con exito");
                break;
        }
    }
}
