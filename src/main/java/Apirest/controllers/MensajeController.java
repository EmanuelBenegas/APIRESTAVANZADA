package Apirest.controllers;

import Apirest.conversores.MensajeConversor;
import Apirest.entities.Mensaje;
import Apirest.entities.Usuario;
import Apirest.requests.MensajeRequest;
import Apirest.responses.MensajeResponse;
import Apirest.services.MensajeService;
import Apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    MensajeConversor conversormensaje = new MensajeConversor();///lo pongo asi porque sino no anda

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

    @RequestMapping(value = "/user/{email}/entrada", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getEntrada(@PathVariable("email")String email,@RequestHeader("emailcomprobante")String emailcomprobacion){
        if(!email.equals(emailcomprobacion)){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else
        {
            try{

                List<Mensaje> listamensajes = mensajeService.getEntrada(email);
                if(listamensajes.size()> 0){
                    return new ResponseEntity<List<MensajeResponse>>(this.convertirlista(listamensajes),HttpStatus.OK);
                }
                else{
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/user/{email}/salida", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getSalida(@PathVariable("email")String email,@RequestHeader("emailcomprobante")String emailcomprobacion){
        if(!email.equals(emailcomprobacion)){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else
        {
            try{

                List<Mensaje> listamensajes = mensajeService.getSalida(email);
                if(listamensajes.size()> 0){
                    return new ResponseEntity<List<MensajeResponse>>(this.convertirlista(listamensajes),HttpStatus.OK);
                }
                else{
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    //corregir si anda correctamente
    @RequestMapping(value = {"/user/{email}/entrada/{id}","/user/{email}/salida/{id}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity leeruno(@RequestBody @PathVariable("email")String email,@RequestHeader("emailcomprobante")String emailcomprobante,@PathVariable("id")Integer id){
        if(!email.equals(emailcomprobante)){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        else {
            try {
                Mensaje m = mensajeService.getUno(id);
                return new ResponseEntity<MensajeResponse>(conversormensaje.convertir(m),HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<MensajeResponse>(HttpStatus.NO_CONTENT);
            }
        }

    }



    public List<MensajeResponse> convertirlista(List<Mensaje> listamensajes){
        List<MensajeResponse> aux = new ArrayList<MensajeResponse>();
        for(Mensaje m : listamensajes){
            aux.add(conversormensaje.convertir(m));
        }
        return aux;
    }
}
