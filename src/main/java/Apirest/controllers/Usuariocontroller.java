package Apirest.controllers;

import Apirest.entities.Usuario;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
