package videojuegos.Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import videojuegos.Modelo.Estudio;

public class EstudioDB {

    public static ArrayList<Estudio> listaEstudios(Connection con) {
        ArrayList<Estudio> ret = new ArrayList<>();

        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM Estudio");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                ret.add(new Estudio(rs.getInt("id"), rs.getInt("equipo_desarrollo"), rs.getString("nombre_estudio"), rs.getInt("id_empresa")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ret;
    }

    public static void insertEmpresaBD(Connection con, Estudio empresa) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sql = "INSERT INTO Estudio VALUES ('" + empresa.getId_Estudio() + "','"
                    + empresa.getEquiposDesarrollo() + "','" + empresa.getNombre() + "','" + empresa.getEmpresa() + "')";

            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modificaEstudio(Connection con, Estudio nuevo) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();

            String sql = "UPDATE Estudio SET equipo_desarrollo='" + nuevo.getEquiposDesarrollo()
                    + "', nombre_estudio='" + nuevo.getNombre() + "' where id='" + nuevo.getId_Estudio() + "';";
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminaEstudio(Connection con, Estudio estudio) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sql = "DELETE FROM Estudio WHERE id = " + estudio.getId_Estudio();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
