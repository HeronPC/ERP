package sge.proyectoerp.Models;

import java.time.LocalDate;

public class Recepciones {
    String referencia;
    String recibir;
    LocalDate dateReferencia;
    String docorigen;
    String nombreproducto;
    int cantidad;

    String contacto;

    String estado;

    public Recepciones( String contacto, String referencia, LocalDate dateReferencia, String docorigen, String estado) {
        this.referencia = referencia;
        this.dateReferencia = dateReferencia;
        this.docorigen = docorigen;
        this.contacto = contacto;
        this.estado = estado;
    }

    public Recepciones(String nombreproducto, int cantidad) {
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }


    public Recepciones(String referencia, String recibir, LocalDate dateReferencia, String docorigen, String nombreproducto, int cantidad) {
        this.referencia = referencia;
        this.recibir = recibir;
        this.dateReferencia = dateReferencia;
        this.docorigen = docorigen;
        this.nombreproducto = nombreproducto;
        this.cantidad = cantidad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getRecibir() {
        return recibir;
    }

    public void setRecibir(String recibir) {
        this.recibir = recibir;
    }

    public LocalDate getDateReferencia() {
        return dateReferencia;
    }

    public void setDateReferencia(LocalDate dateReferencia) {
        this.dateReferencia = dateReferencia;
    }

    public String getDocorigen() {
        return docorigen;
    }

    public void setDocorigen(String docorigen) {
        this.docorigen = docorigen;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
