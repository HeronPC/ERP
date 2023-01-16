package sge.proyectoerp.Models;

import java.time.LocalDate;

public class Devoluciones {
    String docorigen;
    String nombreproducto;
    String contacto;
    String referencia;
    String motivo;
    int cantidad;

    public Devoluciones(String nombreproducto, int cantidad) {
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }

    public Devoluciones(String docorigen, String nombreproducto, String contacto, String referencia, String motivo, int cantidad) {
        this.docorigen = docorigen;
        this.nombreproducto = nombreproducto;
        this.contacto = contacto;
        this.referencia = referencia;
        this.motivo = motivo;
        this.cantidad = cantidad;
    }

    public Devoluciones(String contacto, String referencia, String docorigen, String motivo) {
        this.contacto = contacto;
        this.referencia = referencia;
        this.docorigen = docorigen;
        this.motivo = motivo;
    }

    public String getContacto() {
        return contacto;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getDocorigen() {
        return docorigen;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
