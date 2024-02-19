package org.example.Entity;

public class Genero {
    private String nombre;

    public Genero() {
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
