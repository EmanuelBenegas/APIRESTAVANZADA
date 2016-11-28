package Apirest.conversores;

import Apirest.entities.Mensaje;
import Apirest.responses.MensajeResponse;

/**
 * Created by lcc on 23/11/2016.
 */
public class MensajeConversor {

    UsuarioConversor convertidor = new UsuarioConversor();

    public MensajeResponse convertir(Mensaje m){
        MensajeResponse response = new MensajeResponse();
        response.setId_mensaje(m.getId());
        response.setAsunto(m.getAsunto());
        response.setCuerpo(m.getMensaje());
        response.setRemitente(convertidor.conversor(m.getRemitente()));
        return response;
    }
}
