package ConexionBS;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConexionBS_MYSQL {

    public static Connection ObtenerConexion() {
        Properties config = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            System.out.println("Error al cargar config.properties: " + e.getMessage());
            return null;
        }

        String user = config.getProperty("db.user");
        String password = config.getProperty("db.password");
        String url = config.getProperty("db.url");

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}

