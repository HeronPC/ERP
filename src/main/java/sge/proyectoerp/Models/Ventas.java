package sge.proyectoerp.Models;

import java.time.LocalDate;

public class Ventas {
    String codigo;
    LocalDate fechaprevista;
    String cliente;
    int plazos;
    String producto;
    String cantidad;
    String preciounidad;
    String estado;
    String total;
    float impuestos;
    String subtotal;

    public Ventas(String codigo, LocalDate fechaprevista, String cliente, int plazos, String producto, String cantidad, String preciounidad) {
        this.codigo = codigo;
        this.fechaprevista = fechaprevista;
        this.cliente = cliente;
        this.plazos = plazos;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciounidad = preciounidad;
    }

    public Ventas(String codigo, LocalDate fechaprevista, String cliente, String estado, String total) {
        this.codigo = codigo;
        this.fechaprevista = fechaprevista;
        this.cliente = cliente;
        this.estado = estado;
        this.total = total;
    }

    public Ventas(String codigo, String producto, String cantidad, String preciounidad, float impuestos, String subtotal) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciounidad = preciounidad;
        this.impuestos = impuestos;
        this.subtotal = subtotal;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaprevista() {
        return fechaprevista;
    }

    public void setFechaprevista(LocalDate fechaprevista) {
        this.fechaprevista = fechaprevista;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getPlazos() {
        return plazos;
    }

    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPreciounidad() {
        return preciounidad;
    }

    public void setPreciounidad(String preciounidad) {
        this.preciounidad = preciounidad;
    }
}
