package videojuegos.Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import videojuegos.Modelo.Empresa;

/**
 *
 * @author Esther
 */
public class EmpresaBD {
    
     public static ArrayList<Empresa> getEmpresaBD(Connection con) 
    {
        ArrayList<Empresa> ret = new ArrayList<>();
        
        Statement sentencia;
        
        try
        {
            sentencia = con.createStatement();
            sentencia.executeQuery("SELECT * FROM Empresa");
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                ret.add(new Empresa(rs.getInt("id"), rs.getInt("trabajadores"), rs.getString("nombre_empresa")));
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return ret;
    }

    public static void insertEmpresaBD(Connection con, Empresa empresa) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sql = "INSERT INTO Empresa VALUES ('" + empresa.getId() + "','" + empresa.getNumeroTrabajadores() + "','" + empresa.getNombreEmpresa() + "')";

            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteEmpresaBD(Connection con, Empresa empresa) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            String sqlStr = "DELETE FROM Empresa WHERE id = " + empresa.getId();
            sentencia.executeUpdate(sqlStr);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void modifyEmpresaBD(Connection con, Empresa nueva) {
         Statement sentencia;
        try {
           

            sentencia = con.createStatement();
        
            String sql = "update empresa set trabajadores='" + nueva.getNumeroTrabajadores() + "', nombre_empresa='" + nueva.getNombreEmpresa() + "' where id='" + nueva.getId() + "';";
            sentencia.executeUpdate(sql);
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    /* public static void modificaEstudio(Connection con, Estudio nuevo){
        Statement sentencia;

        try {
            sentencia = con.createStatement();
        
            String sql = "UPDATE Estudio SET equipo_desarrollo='" + nuevo.getEquiposDesarrollo() 
                    + "', nombre_estudio='" + nuevo.getNombre() + "' where id='" + nuevo.getId_Estudio() + "';";
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}
