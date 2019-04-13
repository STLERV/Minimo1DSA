
package Services;

import eetac.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

import javax.ws.rs.core.GenericEntity;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Api(value = "/musica", description = "Endpoint to musica Service")

@Path("/musica")

public class MyMusicImplService {

    final static Logger log = Logger.getLogger(MyMusicImplService.class.getName());
    private MyMusic mm;

    public MyMusicImplService() {
        this.mm = MyMusicImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "Obetener lista de playlists de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "exito", response = Usuari.class, responseContainer = "Lista de de playList de un Usuario"),
    })
    @Path("/{listaplaylistusuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaplaylistusuario(@PathParam("user") String user) throws Exception {
        ArrayList<PlayList> listaplaylist = new ArrayList<>();
        try {

            listaplaylist = mm.listatitolsusuari("idUsuari");
            GenericEntity<List<PlayList>> entity = new GenericEntity<List<PlayList>>(listaplaylist) {
            };
            return Response.status(201).entity(entity).build();
        } catch (UsuarioException e) {
            return Response.status(401).build();
        }
    }

    @POST
    @ApiOperation(value = "Añadir Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "exito")
    })
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Usuari u) {
        mm.addUser(u.getIdUsuari());
        return Response.status(201).build();

    }


    @POST
    @ApiOperation(value = "Añadir Cancion a PlayList Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "exito")
    })
    @Path("/addcancion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCancion(@PathParam("idUser") String idUsuari, Track t, @PathParam("idPlayList") String idPlayList) {
        try {
            mm.añadirtitol("idUser", t, "idplaylist");
            return Response.status(201).build();

        } catch (UsuarioException e) {
            return Response.status(404).build();
        }


    }
}

