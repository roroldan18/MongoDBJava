package org.example.Entity;

public class EscuchasMensuales {

    private Artista artista;
    private int mes;
    private int escuchas;

    public EscuchasMensuales() {
    }

    public EscuchasMensuales(Artista artista, int mes, int escuchas) {
        this.artista = artista;
        this.mes = mes;
        this.escuchas = escuchas;
    }

    @Override
    public String toString() {
        return "{" +
                "artista=" + artista +
                ", mes=" + mes +
                ", escuchas=" + escuchas +
                '}';
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getEscuchas() {
        return escuchas;
    }

    public void setEscuchas(int escuchas) {
        this.escuchas = escuchas;
    }
}
