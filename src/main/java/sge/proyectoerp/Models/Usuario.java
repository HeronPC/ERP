package sge.proyectoerp.Models;

import java.time.LocalDate;

public class Usuario {

    static String nomusuario;


    public Usuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public static String getNomusuario() {
        return nomusuario;
    }

    public static void setNomusuario(String nomusuario) {
        nomusuario = nomusuario;
    }
}
