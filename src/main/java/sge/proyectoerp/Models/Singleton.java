package sge.proyectoerp.Models;

public class Singleton {
    private static Singleton instance;
    private String Usuario;

    public Singleton() {
        // constructor privado para evitar la creación de nuevas instancias
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
        this.Usuario = Usuario;
    }
}

