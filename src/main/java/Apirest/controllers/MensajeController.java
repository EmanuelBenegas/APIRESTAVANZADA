package Apirest.controllers;

import Apirest.entities.Usuario;
import Apirest.requests.MensajeRequest;
import Apirest.services.MensajeService;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lcc on 23/11/2016.
 */
@Controller
@RequestMapping(
        value = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class MensajeController {
    @Autowired
    UsuarioService userservice;

    @Autowired
    MensajeService mensajeService;

    @RequestMapping(value = "/user/{email}/enviarmensaje", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevoMensaje(@RequestBody MensajeRequest mensajereq, @PathVariable("email") String email, @RequestHeader("emailcomprobacion")String emailcomprobacion){
        if(!email.equals(emailcomprobacion)){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else{
            try{
                Usuario remitente = userservice.getbyEmail(email);
                mensajeService.nuevoMensaje(mensajereq.getCuerpomensaje(),mensajereq.getAsunto(),remitente,mensajereq.getRecipientes());
                return new ResponseEntity(HttpStatus.CREATED);
            }
            catch (Exception e){
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
