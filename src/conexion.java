import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class conexion {


    public Connection getConexion(){
        String URL= "jdbc:mysql://localhost:3306/inventario";
        String USER = "root";
        String PASS = "HTCjdg1998#$%&";
      Connection conn = null;
      try{
          conn = DriverManager.getConnection(URL, USER, PASS);
          //int update = conn.

          return conn;
      }catch (Exception e){
          e.printStackTrace();
          return conn;
      }
    };

    public void insertarProducto(Connection conn, producto producto){
        String sql ="INSERT INTO PRODUCTOS (nombre, precio) VALUES (?,?)";

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            int update = statement.executeUpdate();
            if(update>0){
                System.out.println("Producto Insertado con exito");
            }else{
                System.out.println("No se pudo insertar el producto");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    };
    public void eliminarProducto(Connection conn, String nombre){
        String sql = "DELETE FROM PRODUCTOS WHERE nombre=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            int update = statement.executeUpdate();
            if(update>0){
                System.out.println("Producto Eliminado con exito");
            }else{
                System.out.println("No se pudo Eliminar el producto");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizarProducto(Connection conn, int precio, String nombre){
        String sql = "UPDATE PRODUCTOS SET precio = ? WHERE nombre = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, precio);
            statement.setString(2, nombre);
            int update = statement.executeUpdate();
            if(update>0){
                System.out.println("Producto actualizado con exito");
            }else{
                System.out.println("No se pudo actualizar el producto");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<producto> obtenerProductos(Connection conn){
        String sql = "SELECT * FROM PRODUCTOS";
        List<producto> listaProductos = new ArrayList<>();
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-----------------------------------------------------");
            System.out.println("Id producto      nombre producto      precio producto");
            System.out.println("-----------------------------------------------------");
            while (resultSet.next()){
                listaProductos.add(new producto(resultSet.getString("nombre"), resultSet.getInt("precio")));
                String espaciosNombreProducto ="";
                int tamanoNombre = resultSet.getString("nombre").length();
                for(int i= tamanoNombre; i<=21;i++){
                    espaciosNombreProducto+= " ";
                }

                System.out.println(resultSet.getInt("id")+"                "+ resultSet.getString("nombre")+espaciosNombreProducto+resultSet.getInt("precio"));
                System.out.println("-----------------------------------------------------");
            }
            return listaProductos;
        }catch (Exception e){
            e.printStackTrace();
            return listaProductos;
        }
    }

}
