package TestConexionOracle;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {
    public static void main(String[] args) {
    String url = "jdbc:oracle:thin:@SisVentaRBR_high ?TNS_ADMIN=D:/RBR_T11BF/app01/wallet";
        String username = "NANDOWO";
        String password = "N4nd0oWo12345";

        try {
            // Cargar el driver de Oracle
            Class.forName("oracle.jdbc.OracleDriver");
            
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Verificar si la conexión es exitosa
            if (connection != null) {
                System.out.println("¡Conexión exitosa!");
                
                // Obtener información de la base de datos
                DatabaseMetaData metaData = connection.getMetaData();
                String dbName = metaData.getDatabaseProductName();
                String dbVersion = metaData.getDatabaseProductVersion();
                
                System.out.println("Nombre de la base de datos: " + dbName);
                System.out.println("Versión de la base de datos: " + dbVersion);
                
                connection.close(); // Cerrar la conexión después de usarla
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de Oracle: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
