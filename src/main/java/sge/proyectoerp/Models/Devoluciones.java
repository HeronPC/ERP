package sge.proyectoerp.Models;

import java.time.LocalDate;

public class Devoluciones {
    String recibir;
    LocalDate date;
    String docorigen;
    String nombreproducto;
    String tipo;
    int cantidad;

    public Devoluciones(String nombreproducto, int cantidad) {
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }


    public Devoluciones(String recibir, LocalDate date, String tipo, String docorigen, String nombreproducto, int cantidad) {
        this.recibir = recibir;
        this.date = date;
        this.tipo = tipo;
        this.docorigen = docorigen;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRecibir() {
        return recibir;
    }

    public LocalDate getDateReferencia() {
        return date;
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
