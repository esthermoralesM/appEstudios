package videojuegos.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverMySql {

    private static volatile DriverMySql instance = null;

    private String bd = "videojuegos";
    private String usuario = "root";
    private String password = "1234";

    private Connection conn = null;

    public static DriverMySql getInstance() {
        if (instance == null) {

            synchronized (DriverMySql.class) {
                if (instance == null) {
                    instance = new DriverMySql();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {
        Connection ret = null;

        ret = ConnectarBD();

        return ret;
    }

    private DriverMySql() {
        this.ConnectarBD();
    }

    /**
     * Conecta a una BD mysql y gestiona la connexión
     *
     * @return objeto Connection
     * @throws SQLException
     */
    private Connection ConnectarBD() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd + "?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex.getMessage());
        }

        return conn;
    }

    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Error inicializando la conexión " + ex.getMessage());
        }
    }
}
