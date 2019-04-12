package eetac;
import java.util.ArrayList;
import java.util.LinkedList;

public class Usuari {

    String idUsuari;
    ArrayList<PlayList> listaplaylist;
    LinkedList<Track> listatitol;

    public Usuari(String idUsuari, ArrayList<PlayList> listaplaylist) {
        this.idUsuari = idUsuari;
        this.listaplaylist = listaplaylist;
    }
    public Usuari( String idUsuari){
        this.idUsuari = idUsuari;
    }

    public ArrayList<PlayList> getListaplaylist() {
        return listaplaylist;
    }

    public void setListaplaylist(ArrayList<PlayList> listaplaylist) {
        this.listaplaylist = listaplaylist;
    }

    public LinkedList<Track> getListatitol() {
        return listatitol;
    }

    public void setListatitol(LinkedList<Track> listatitol) {
        this.listatitol = listatitol;
    }

    public String getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(String idUsuari) {
        this.idUsuari = idUsuari;
    }
}
