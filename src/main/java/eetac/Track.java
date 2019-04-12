package eetac;

public class Track {
    String titol;
    String artista;
    String album;
    double duracio;

    public Track(String titol, String artista, String album, double duracio) {
        this.titol = titol;
        this.artista = artista;
        this.album = album;
        this.duracio = duracio;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getDuracio() {
        return duracio;
    }

    public void setDuracio(double duracio) {
        this.duracio = duracio;
    }
}
