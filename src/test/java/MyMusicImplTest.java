import eetac.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class MyMusicImplTest {
    final static org.apache.log4j.Logger log = Logger.getLogger(MyMusicImpl.class.getName());
    MyMusic mm;

    @Before

    public void SetUp() {

        log.info("Hola");
        mm = MyMusicImpl.getInstance();
        this.mm = new MyMusicImpl();
        this.mm.addUser("1");
        this.mm.addUser("2");

        Track t = new Track("a","Q", "aa",33);
        this.mm.addTrack("A", "Q", "aa", 33);


    }

    @Test
    public void addUsersTest() {


        Assert.assertEquals(2, mm.numUsers());
    }


    @Test
    public void addTracktest() {


        Assert.assertEquals(1, mm.numCanciones());

    }
    @Test
    public void addTrackaunaPlayListUsuariTest() throws UsuarioException{
        Track t = new Track("a","Q", "aa",33);
        PlayList playlist = new PlayList("PlayList", "1");
        this.mm.añadirtitol("1",t, "PlayList");
        Assert.assertEquals(1, mm.numCanciones());

    }




    @Test
    public void crarplaylistusuaritest() throws UsuarioException{


        PlayList playlist = new PlayList("PlayList", "1");
        this.mm.crearplaylist( "1");
        this.mm.crearplaylist( "1");
        Assert.assertEquals(2, mm.numPlaylist("1"));

    }

    @After

    public void tearDown(){
        this.mm = null;

    }

}

//a


