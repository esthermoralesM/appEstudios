/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos.Vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import videojuegos.Controlador.LogicaEmpresa;
import static videojuegos.Controlador.LogicaEmpresa.getEmpresa;
import videojuegos.Controlador.LogicaEstudio;
import static videojuegos.Controlador.LogicaEstudio.getEstudios;
import videojuegos.Controlador.LogicaJuego;
import videojuegos.Modelo.Empresa;
import videojuegos.Modelo.Estudio;
import videojuegos.Modelo.Videojuego;

public class Videojuegos {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    static ArrayList<Empresa> empresas = getEmpresa();
    static ArrayList<Estudio> estudios = getEstudios();
    static ArrayList<Videojuego> juegos = LogicaJuego.getVideojuegos();

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        int opcion = 0;
        do {

            System.out.println("Sobre que tabla quiere incidir");
            System.out.println("1. Empresa");
            System.out.println("2. Videojuego");
            System.out.println("3. Estudio");
            System.out.println("0. Salir");

            opcion = pedirEntero("Introduce una opcion del menu: ");

            switch (opcion) {
                case 1:
                    operacionAefectuar(opcion);
                case 2:
                    operacionAefectuar(opcion);
                case 3:
                    operacionAefectuar(opcion);
            }

        } while (opcion != 0);
    }

    public static void operacionAefectuar(int clase) {

        int opcion;

        System.out.println("1. Insertar");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar");
        System.out.println("4. Listar contenido");

        opcion = pedirEntero("¿Qué operacion quieres efectuar? ");

        try {
            switch (clase) {
                case 1:
                    Empresa e1 = new Empresa();
                    ;
                    switch (opcion) {

                        case 1:

                            e1.datosEmpresa();
                            LogicaEmpresa.insertEmpresa(e1);

                            break;
                        case 2:
                            e1 = modificacionEmpresa();
                            LogicaEmpresa.modifyEmpresaBD(e1);

                            break;

                        case 3:
                            LogicaEmpresa.deleteEmpresa(eliminadorEmpresa());
                            break;
                        case 4:
                            mostrarEmpresas();
                            break;
                    }
                    break;

                case 2:
                    switch (opcion) {
                        case 1:
                            //aun no va
                            Videojuego vi = generaJuego();
                            LogicaJuego.insertJuego(vi);
                            break;
                        case 2:
                            LogicaJuego.modificaJuego(modificadorJuego());
                            break;
                        case 3:
                            LogicaJuego.eliminaVideojuego(eliminadorJuego());
                            break;
                        case 4:
                            listaVideojuegos();
                            break;
                    }
                    break;
                case 3:
                    Estudio es;
                    switch (opcion) {
                        case 1:
                            es = generaEstudio();
                            LogicaEstudio.insertaEstudio(es);
                            break;
                        case 2:
                            es = modificacionEstudio();
                            LogicaEstudio.modEstudio(es);
                            break;
                        case 3:
                            LogicaEstudio.delEstudio(eliminarEstudio());
                            break;
                        case 4:
                            listaEstudios();
                            break;
                    }
                    break;
            }
            empresas = getEmpresa();
            estudios = getEstudios();
            juegos = LogicaJuego.getVideojuegos();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void mostrarEmpresas() {
        for (Empresa e : empresas) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public static void listaOrdenadaEmpresas() {
        int cont = 0;
        for (Empresa e : empresas) {
            cont++;
            if (e != null) {
                System.out.println("\t" + cont + ". " + e);
            }
        }
    }

    public static int pedirEntero(String pregunta) {
        boolean estado = true;
        int num = 0;
        String noInt;
        do {

            try {
                System.out.print(pregunta);
                num = in.nextInt();
                estado = false;
                if (num < 0) {
                    throw new InputMismatchException("El numero no puede ser menor que 0.");
                }

            } catch (InputMismatchException e) {
                noInt = in.nextLine();
                System.out.println(noInt + " Error: " + e.getMessage());

            }
        } while (estado);
        return num;
    }

    //<editor-fold defaultstate="collapsed" desc="Estudio">
    private static Estudio generaEstudio() throws Exception {
        String nombre;
        int equipo, id, opcion, propietario;

        id = pedirEntero("Deme su identificador numerico: ");
        System.out.println("Dame el nombre");
        in.nextLine();
        nombre = in.nextLine();
        equipo = pedirEntero("Numero de equipos: ");

        listaOrdenadaEmpresas();
        if (empresas.size() > 0) {
            opcion = pedirEntero("¿A que empresa pertenece? Elija una opción: ");
            if (opcion < 0 || opcion > empresas.size()) {
                System.out.println("Opcion no valida");
            } else {
                propietario = empresas.get(opcion - 1).getId();
                Estudio es = new Estudio(id, equipo, nombre, propietario);
                return es;
            }
        } else {
            throw new Exception("No hay empresas, no puede continuar");
        }
        return null;
    }

    private static Estudio modificacionEstudio() {
        int eleccion, desarollo, propietario;
        String nombre;
        Estudio elegido;

        listaOrdenadaEstudios();
        eleccion = pedirEntero("Que tabla modificara? Elija una opción: ");
        elegido = estudios.get(eleccion - 1);
        System.out.print("Dale un nuevo nombre: ");
        in.nextLine();
        nombre = in.nextLine();
        desarollo = pedirEntero("Grupos de desarrollo: ");
        listaOrdenadaEmpresas();
        propietario = pedirEntero("Nuevo porpietario (elige una opción): ");

        if (eleccion > empresas.size() && propietario > empresas.size()) {
            System.out.println("Opcion no valida");
        } else {
            propietario = empresas.get(propietario - 1).getId();
            Estudio es = new Estudio(elegido.getId_Estudio(), desarollo, nombre, propietario);
            return es;
        }
        return null;
    }

    private static Estudio eliminarEstudio() {
        int estudio;
        listaOrdenadaEstudios();

        estudio = pedirEntero("¿Que estudio eliminara? Escoja una opción: ");

        if (estudio > estudios.size()) {
            System.out.println("Opcion no valida");
        } else {
            return estudios.get(estudio - 1);
        }
        return null;

    }

    public static void listaEstudios() {
        for (Estudio e : estudios) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public static void listaOrdenadaEstudios() {
        int cont = 0;
        for (Estudio e : estudios) {
            cont++;
            if (e != null) {
                System.out.println("\t" + cont + ". " + e);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Videojuego">
    public static void listaVideojuegos() {
        for (Videojuego e : juegos) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    public static void listaOrdenadaVideoojuegos() {
        int cont = 0;
        for (Videojuego e : juegos) {
            cont++;
            if (e != null) {
                System.out.println("\t" + cont + ". " + e);
            }
        }
    }

    private static Videojuego generaJuego() throws Exception {
        String nombre;
        int eleccion, id, niveles;

        id = pedirEntero("Deme su identificador numerico: ");
        System.out.print("Dame el nombre");
        in.nextLine();
        nombre = in.nextLine();
        niveles = pedirEntero("¿Cuantos niveles tendra el videojuego? ");

        listaOrdenadaEstudios();

        if (estudios.size() > 0) {
            eleccion = pedirEntero("¿Que estudio lo desarrolla? Escoja una opción: ");
            if (eleccion > estudios.size()) {
                System.out.println("Opcion no valida");
            } else {
                Estudio propietario = estudios.get(eleccion - 1);
                Videojuego vi = new Videojuego(id, niveles, nombre, propietario.getEmpresa(), propietario.getId_Estudio());
                return vi;
            }
        } else {
            throw new Exception("No hay estudios, no puede continuar");
        }
        return null;
    }

    private static Videojuego modificadorJuego() {
        String nombre;
        int eleccion, niveles, juego;

        listaOrdenadaVideoojuegos();
        juego = pedirEntero("Elija el videojuego a modificar: ");

        System.out.print("Nuevo nombre: ");
        in.nextLine();
        nombre = in.nextLine();

        niveles = pedirEntero("Nuevo numero de niveles: ");

        listaOrdenadaEstudios();
        eleccion = pedirEntero("Nuevo estudio de desarrollo: ");

        if (juego > juegos.size() && eleccion > estudios.size()) {
            System.out.println("Opcion no valida");
        } else {
            Estudio propietario = estudios.get(eleccion - 1);
            Videojuego vi = new Videojuego(juegos.get(juego - 1).getIdVideojuego(), niveles, nombre,
                    propietario.getEmpresa(), propietario.getId_Estudio());
            return vi;
        }
        return null;
    }

    private static Videojuego eliminadorJuego() {
        int juego;

        listaOrdenadaVideoojuegos();
        juego = pedirEntero("¿Que juego desea eliminar? Elija una opción: ");

        if (juego > juegos.size()) {
            System.out.println("Opcion no valida");
        } else {
            return juegos.get(juego - 1);
        }
        return null;

    }

    private static Empresa eliminadorEmpresa() {
        int empr;

        listaOrdenadaEmpresas();
        empr = pedirEntero("¿Que empresa desea eliminar? Elija una opción: ");

        if (empr > empresas.size()) {
            System.out.println("Opcion no valida");
        } else {
            return empresas.get(empr - 1);
        }
        return null;

    }

    private static Empresa modificacionEmpresa() {
        int eleccion, trabajador;
        String nombre;
        Empresa elegida;

        listaOrdenadaEmpresas();
        eleccion = pedirEntero("Que tabla modificara? Elija una opción: ");
        elegida = empresas.get(eleccion - 1);
        System.out.print("Dale un nuevo nombre: ");
        in.nextLine();
        nombre = in.nextLine();
        trabajador = pedirEntero("numero de trabajadores: ");
        // listaOrdenadaEmpresas();

        if (eleccion > empresas.size()) {
            System.out.println("Opcion no valida");
        } else {
            // propietario = empresas.get(propietario - 1).getId();
            Empresa em = new Empresa(elegida.getId(), trabajador, nombre);
            return em;
        }
        return null;
    }

    //</editor-fold>
}
