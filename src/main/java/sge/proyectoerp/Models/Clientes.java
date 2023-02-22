package sge.proyectoerp.Models;

public class Clientes {
    String CIF;
    String Nombre;
    String Direccion;
    String email;
    String Tel;

    public Clientes(String CIF, String nombre, String direccion, String email, String tel) {
        this.CIF = CIF;
        Nombre = nombre;
        Direccion = direccion;
        this.email = email;
        Tel = tel;
    }

    public Clientes(String nombre) {
        Nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
}
