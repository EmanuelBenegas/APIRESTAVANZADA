package Apirest.controllers;

import Apirest.entities.Usuario;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
