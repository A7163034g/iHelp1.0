package com.dominio.ihelp10.modelos;

public class Usuario {

    private String id;
    private String nombre;
    private String cedula;
    private String email;
    private String tipo;
    private long tiempoCreacion;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String cedula, String email , long tiempoCreacion, String tipo) {

        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;

        this.tiempoCreacion = tiempoCreacion;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTiempoCreacion() {
        return tiempoCreacion;
    }

    public void setTiempoCreacion(long tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
