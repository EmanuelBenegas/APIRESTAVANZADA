package Apirest.controllers;

import Apirest.conversores.UsuarioConversor;
import Apirest.entities.Usuario;
import Apirest.responses.UserResponse;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lcc on 22/11/2016.
 */
@RestController

@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class Usuariocontroller {
    @Autowired
    UsuarioService userservice;

    UsuarioConversor convertidor = new UsuarioConversor();

    ///@RequestMapping(value = "/usuario/{mail}", method = RequestMethod.GET)
    ///public ResponseEntity traerUsuario(@RequestBody @PathVariable("email") String email){

    //}

    @RequestMapping(value = "/user/{email}/modificarusuario",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity modificarUsuario(@RequestParam("nombre")String nombre,
                                           @RequestParam("apellido")String apellido,
                                           @RequestParam("direccion")String direccion,
                                           @RequestParam("telefono")String telefono,
                                           @RequestParam("ciudad")String ciudad,
                                           @RequestParam("provincia")String provincia,
                                           @RequestParam("pais")String pais,@PathVariable ("email")String email,@RequestHeader("sessionid") String sessionid){
        //falta validarlo


        try{
            userservice.modificarUsuario(email,nombre,apellido,direccion,telefono,ciudad,provincia,pais);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(HttpStatus.NO_CONTENT);
        }


    }

    @RequestMapping(value = "/user/{email}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity mostrarDatos(@RequestBody @PathVariable("email")String email){
        try{
            Usuario user = userservice.getbyEmail(email);
            return new ResponseEntity<UserResponse>(convertidor.conversor(user),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
