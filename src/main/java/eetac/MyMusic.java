package eetac;

import java.util.ArrayList;
import java.util.LinkedList;

public interface MyMusic {

    public void addUser(String idUsuari);
    public ArrayList<PlayList> listatitolsusuari(String idUsuari) throws UsuarioException;
    public void addTrack( String titol, String artista, String album, double duracion);
    public void añadirtitol (String idUser, Track t, String idPlayList) throws UsuarioException;
    public void crearplaylist (String idUsuari) throws UsuarioException;
    public int numUsers();
    public int numPlaylist( String idUsuari);
    public int numCanciones();


}
