package sge.proyectoerp.Models;

public class Singleton {
    private static Singleton instance;
    private static String Usuario;

    private static String titstage;
    private static String nombrebd;

    public String getTitstage() {
        return titstage;
    }

    public void setTitstage(String titstage) {
        Singleton.titstage = titstage;
    }

    public Singleton() {
        // constructor privado para evitar la creación de nuevas instancias
    }

    public static String getNombrebd() {
        return nombrebd;
    }

    public static void setNombrebd(String nombrebd) {
        Singleton.nombrebd = nombrebd;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        Singleton.Usuario = Usuario;
    }
}

