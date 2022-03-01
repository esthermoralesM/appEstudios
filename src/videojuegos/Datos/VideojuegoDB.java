package videojuegos.Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import videojuegos.Modelo.Videojuego;

public class VideojuegoDB {

    public static ArrayList<Videojuego> listaVideojuegos(Connection con) {
        ArrayList<Videojuego> ret = new ArrayList<>();

        Statement sentencia;
        try {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM Videojuego");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                ret.add(new Videojuego(rs.getInt("id"), rs.getInt("numero_niveles"), rs.getString("nombre"), rs.getInt("id_empresa"), rs.getInt("id_estudio")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ret;
    }

    public static void insertVideojuego(Connection con, Videojuego empresa) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sql = "INSERT INTO Videojuego VALUES ('" + empresa.getIdVideojuego() + "','"
                    + empresa.getNumNiveles() + "','" + empresa.getNombreJuego() + "','"
                    + empresa.getIdEmpresa() + "','" + empresa.getIdEstudio() + "')";

            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modificaVideojuego(Connection con, Videojuego estudio) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();

            String sql = "UPDATE Videojuego SET numero_niveles='" + estudio.getNumNiveles()
                    + "', nombre='" + estudio.getNombreJuego() + "' where id='" + estudio.getIdVideojuego() + "';";
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminaVideojuego(Connection con, Videojuego estudio) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sql = "DELETE FROM Videojuego WHERE id = " + estudio.getIdVideojuego();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
