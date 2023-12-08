import java.util.Scanner;
public class opcionesUsuario {

    public static int mostrarOpciones(){
        System.out.println("Sistema de inventario");
        System.out.println("1. Ingrese 1 para visualizar los productos");
        System.out.println("2. Ingrese 2 para añadir un nuevo producto");
        System.out.println("3. Ingrese 3 para cambiar el precio a un producto");
        System.out.println("4. Ingrese 4 para eliminar un producto");
        System.out.println("5. Ingrese 5 para detener la ejecucion del programa");
        Scanner input = new Scanner(System.in);
        String opcionSeleccionada = input.next();

        try{
            int numeroSeleccionado = Integer.parseInt(opcionSeleccionada);
            if(numeroSeleccionado==5){
                return 5;
            }else if(numeroSeleccionado>5 || numeroSeleccionado<1){
                System.out.println("");
                System.out.println("El numero debe estar entre 1 a 5 de otro modo la opcion no es valida");
                return opcionesUsuario.mostrarOpciones();

            }else{
                return Integer.parseInt(opcionSeleccionada);
            }
        }catch (Exception e){
            System.out.println("");
            System.out.println("No puedes ingresar una letra o un caracter, recuerda que debe ser un numero");
            return opcionesUsuario.mostrarOpciones();
        }

    }
}
