package Apirest.controllers;

import Apirest.entities.Usuario;
import Apirest.responses.LoginResponseWrapper;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import Apirest.util.SessionData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

/**
 * Created by lcc on 23/11/2016.
 */
@RestController
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class Logincontroller {

    @Autowired
    SessionData sessionData;

    @Autowired
    UsuarioService userservice;

    @RequestMapping(value = "/iniciosesion", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<LoginResponseWrapper> getUserforLogin(@RequestParam("email")String email,@RequestParam("password")String password){
        Usuario user = userservice.getUserforLogin(email,password);
        if(null != user){
            String sessionid = sessionData.addSession(user);
            return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionid),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);

    }

    @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity nuevoUsuario(@RequestParam("nombre")String nombre,
                                       @RequestParam("apellido")String apellido,
                                       @RequestParam("direccion")String direccion,
                                       @RequestParam("telefono")String telefono,
                                       @RequestParam("ciudad")String ciudad,
                                       @RequestParam("provincia")String provincia,
                                       @RequestParam("pais")String pais,
                                       @RequestParam("email")String email, @RequestParam("password")String password){
        try{
            userservice.Usernew(nombre,apellido,direccion,telefono,ciudad,provincia,pais,email,password);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @RequestMapping(value = "/cerrarsesion")
    public
    @ResponseBody
    ResponseEntity cerrarporid(@RequestHeader("sessionid") String sessionid){
        sessionData.removeSession(sessionid);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
