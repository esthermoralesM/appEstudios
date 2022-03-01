package videojuegos.Modelo;

public class Estudio {

    private int Id_Estudio;
    private int EquiposDesarrollo;
    private String Nombre;
    private int empresa;

    public Estudio(int Id_Estudio, int EquiposDesarrollo, String Nombre, int empresa) {
        this.Id_Estudio = Id_Estudio;
        this.EquiposDesarrollo = EquiposDesarrollo;
        this.Nombre = Nombre;
        this.empresa = empresa;
    }

    //<editor-fold defaultstate="collapsed" desc="Geters y seters">
    public int getId_Estudio() {
        return Id_Estudio;
    }

    public int getEquiposDesarrollo() {
        return EquiposDesarrollo;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setId_Estudio(int Id_Estudio) {
        this.Id_Estudio = Id_Estudio;
    }

    public void setEquiposDesarrollo(int EquiposDesarrollo) {
        this.EquiposDesarrollo = EquiposDesarrollo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return "Identificador: " + Id_Estudio + " | Nombre: " + Nombre + " | Equipos de desarrollo: " + EquiposDesarrollo + " | Empresa matriz: " + empresa + '.';
    }

}
