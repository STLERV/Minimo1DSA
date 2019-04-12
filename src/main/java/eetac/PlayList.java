package eetac;

import java.util.LinkedList;

public class PlayList {
    String idPlayList;
    String idUsuari;
LinkedList<Track> listatracks;

    public PlayList(String idPlayList, String idUsuari, LinkedList<Track> listatracks) {
        this.idPlayList = idPlayList;
        this.idUsuari = idUsuari;
        this.listatracks = listatracks;
    }
    public PlayList(String idPlayList, String idUsuari) {
        this.idPlayList = idPlayList;
        this.idUsuari = idUsuari;
    }
    public PlayList(String idPlayList) {
        this.idPlayList = idPlayList;}

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(String idUsuari) {
        this.idUsuari = idUsuari;
    }

    public LinkedList<Track> getListatracks() {
        return listatracks;
    }

    public void setListatracks(LinkedList<Track> listatracks) {
        this.listatracks = listatracks;
    }
}
