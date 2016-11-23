package Apirest.controllers;

import Apirest.entities.Usuario;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    ///@RequestMapping(value = "/usuario/{mail}", method = RequestMethod.GET)
    ///public ResponseEntity traerUsuario(@RequestBody @PathVariable("email") String email){

    //}

    @RequestMapping(value = "/modificarusuario",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity modificarUsuario(@RequestParam("nombre")String nombre,
                                           @RequestParam("apellido")String apellido,
                                           @RequestParam("direccion")String direccion,
                                           @RequestParam("telefono")String telefono,
                                           @RequestParam("ciudad")String ciudad,
                                           @RequestParam("provincia")String provincia,
                                           @RequestParam("pais")String pais){
        //hay que buscarlo y despues comparar

        return new ResponseEntity(HttpStatus.OK);

    }
}
