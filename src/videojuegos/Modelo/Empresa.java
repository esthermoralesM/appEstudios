/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.Modelo;

import java.util.Scanner;
import videojuegos.Vista.Videojuegos;

/**
 *
 * @author Esther
 */
public class Empresa {
    
    private int id;
    private int numeroTrabajadores;
    private String nombreEmpresa;

    public Empresa() {
    }
    
    

    public Empresa(int id, int numeroTrabajadores, String nombreEmpresa) {
        this.id = id;
        this.numeroTrabajadores = numeroTrabajadores;
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTrabajadores() {
        return numeroTrabajadores;
    }

    public void setNumeroTrabajadores(int numeroTrabajadores) {
        this.numeroTrabajadores = numeroTrabajadores;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " numero de trabajadores: " + this.getNumeroTrabajadores() + " nombre de empresa: " + this.getNombreEmpresa()+"\n";
    }
    
     public void datosEmpresa() {  //Pedimos los datos Implementamos el metodo de la interfaz
        Scanner sc = new Scanner(System.in);
     
        this.id = Videojuegos.pedirEntero("Introduce el ID de la Empresa");

        
        this.numeroTrabajadores = Videojuegos.pedirEntero("Número de trabajadores:"); 
      
         System.out.println("Nombre de la Empresa: ");
         this.nombreEmpresa=sc.nextLine();

    }
    
    
}
