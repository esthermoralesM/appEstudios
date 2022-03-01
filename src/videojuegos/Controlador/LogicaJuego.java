package videojuegos.Controlador;

import java.util.ArrayList;
import videojuegos.Datos.DriverMySql;
import videojuegos.Datos.VideojuegoDB;
import videojuegos.Modelo.Videojuego;

public class LogicaJuego {

    private static DriverMySql conn = DriverMySql.getInstance();

    public static ArrayList<Videojuego> getVideojuegos() {
        ArrayList<Videojuego> ret;

        ret = VideojuegoDB.listaVideojuegos(conn.getConnection());
        return ret;
    }

    public static void insertJuego(Videojuego e) {
        VideojuegoDB.insertVideojuego(conn.getConnection(), e);
        conn.closeConnection();
    }

    public static void modificaJuego(Videojuego e) {
        VideojuegoDB.modificaVideojuego(conn.getConnection(), e);
        conn.closeConnection();
    }

    public static void eliminaVideojuego(Videojuego e) {
        VideojuegoDB.eliminaVideojuego(conn.getConnection(), e);
        conn.closeConnection();
    }
}
