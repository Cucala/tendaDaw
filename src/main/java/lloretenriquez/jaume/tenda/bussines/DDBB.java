package lloretenriquez.jaume.tenda.bussines;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DDBB {
    private static Connection connection;
    private static Statement query;
    private static final String URL = "jdbc:postgresql://localhost:5432/tenda?user=postgres&password=1234";

    public static boolean login(String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL);
            query = connection.createStatement();
            String sql  = "SELECT id FROM users WHERE username = '"+user+"' AND password = '"+ password+"'";
            ResultSet result = query.executeQuery(sql);
            result.next();
            return result.getInt(1) > 0 ? true : false;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("No se han podido obtener datos");
        } catch (ClassNotFoundException e) {
            System.err.println("No se ha podido establecer la conexion");
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("No se ha podido cerrar la conexion");
            }
        }
        return false;
    }

    public static ArrayList<ArrayList<String>> mostrarVistaUsuarios(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL);
            query = connection.createStatement();
            String sql  = "SELECT * FROM users ";
            ResultSet result = query.executeQuery(sql);
            ArrayList<ArrayList<String>> datos = new ArrayList<>();
            while (result.next()) {
                ArrayList<String> user = new ArrayList<>();
                user.add(Integer.toString(result.getInt(1)));
                user.add(result.getString(2));
                user.add(result.getString(3));
                user.add(result.getString(4));
                user.add(Integer.toString(result.getInt(5)));
                user.add(result.getString(6));
                user.add(result.getString(7));
                datos.add(user);
            }
            for (ArrayList<String> array : datos) {
                for (String dato : array) {
                    System.out.print(dato + " ");
                }
                System.out.println();
            }
            return datos;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("No se han podido obtener datos");
        } catch (ClassNotFoundException e) {
            System.err.println("No se ha podido establecer la conexion");
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("No se ha podido cerrar la conexion");
            }
        }
        return null;
    }

}