package eetac;

import org.apache.log4j.Logger;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyMusicImpl implements MyMusic {

    final static Logger log = Logger.getLogger(MyMusicImpl.class.getName());
    private static MyMusic instance;

    private HashMap<String, Usuari> listausers;
    private LinkedList<Track> listatatracks;
    private LinkedList<Artista> listaartistas;
    private ArrayList<PlayList> listaplaylist;

    public MyMusicImpl() {

        listausers = new HashMap<String, Usuari>();
        listatatracks = new LinkedList<Track>();
        listaartistas = new LinkedList<Artista>();
        listaplaylist = new ArrayList<PlayList>();

    }

    public static MyMusic getInstance() {
        if (instance == null) instance = new MyMusicImpl();

        return instance;

    }

    //////////////////////////////////////////
    public void addUser(String idUsuari) {

        log.info("AñadiendoUsuario");
        Usuari u = new Usuari(idUsuari);
        this.listausers.put(idUsuari, u);
        log.info("Usuario añadido con exito " + idUsuari);
    }

    public int numUsers() {

        return this.listausers.size();

    }
    public int numCanciones() {

        return this.listatatracks.size();

    }


    public void addTrack(String titol, String artista, String album, double duracion) {
        log.info("Añadiendocancion");
        Track t = new Track(titol,artista,album,duracion);
        listatatracks.add(t);
}
    public ArrayList<PlayList> listatitolsusuari(String idUsuari) throws UsuarioException{

        log.info("llistar les playList de un usuari");
        ArrayList<PlayList> listaplaylist = new ArrayList<>();
        Usuari u = listausers.get(idUsuari);
        if (u != null)
            listaplaylist = u.getListaplaylist();
        else {
            log.info("error encontrando el usuario");
            throw new UsuarioException();
        }

        return listaplaylist;
    }
    public int numPlaylist( String idUsuari) {

        Usuari u = this.listausers.get(idUsuari);
        return u.listaplaylist.size();

    }



    public void añadirtitol(String idUser, Track t, String idPlayList) throws UsuarioException {
        log.info(" afegir una canço a la llista de un usuari");
        Usuari u = this.listausers.get(idUser);
        if (u != null) {

            for (int i = 0; i < this.listaplaylist.size(); i++) {

                if (idPlayList.equals(this.listaplaylist.get(i).getIdPlayList())) {
                    PlayList playlist = this.listaplaylist.get(i);
                    playlist.listatracks.add(t);
                } else {

                    log.info("no existe el id de la playlist");
                }
            }
        }
        else {
            throw new UsuarioException();
        }
    }


    public void crearplaylist( String idUsuari) throws UsuarioException {

        log.info(" crear una PlayList a la llista de un usuari");
        Usuari u = this.listausers.get(idUsuari);

        PlayList playlist = new PlayList(idUsuari);

        if (u != null) {

       u.getListaplaylist().add(playlist);

        } else {
            log.error("Usuario");
            throw new UsuarioException();

        }
    }
}