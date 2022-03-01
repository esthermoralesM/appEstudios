package videojuegos.Controlador;

import java.util.ArrayList;
import videojuegos.Datos.DriverMySql;
import videojuegos.Datos.EmpresaBD;
import videojuegos.Modelo.Empresa;

/**
 *
 * @author Esther
 */
public class LogicaEmpresa {
     private static DriverMySql conn = DriverMySql.getInstance();
    
     public static ArrayList<Empresa> getEmpresa()
    {
       // DriverMySql conn = null;
        ArrayList<Empresa> ret = null;
        
       
          //  conn = DriverMySql.getInstance();
            ret = EmpresaBD.getEmpresaBD(conn.getInstance().getConnection());
            conn.closeConnection();
        
        
        return ret;
    }

    public static void insertEmpresa(Empresa e) {
       // DriverMySql conn = null;

       // conn = DriverMySql.getInstance();

        EmpresaBD.insertEmpresaBD(conn.getInstance().getConnection(), e);
        conn.closeConnection();

    }
    
    
    public static void deleteEmpresa(Empresa e) 
    {
       // DriverMySql conn = null;
        
      
           // conn = DriverMySql.getInstance();
            EmpresaBD.deleteEmpresaBD(conn.getInstance().getConnection(), e);
            conn.closeConnection();
       
    } 
    
    
    
    public static void modifyEmpresaBD(Empresa e) 
    {
      //  DriverMySql conn = null;
        
      
         
            
           // conn = DriverMySql.getInstance();
            EmpresaBD.modifyEmpresaBD(conn.getInstance().getConnection(), e);
            conn.closeConnection();
       
    //}
    }  

}
