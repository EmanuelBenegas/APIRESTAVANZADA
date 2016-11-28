package Apirest.services;

import Apirest.entities.Mensaje;
import Apirest.entities.Usuario;
import Apirest.persistence.MensajeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
@Service
public class MensajeService {
    MensajeDAO mensdao;

    @Autowired
    public  MensajeService(MensajeDAO mens){
        this.mensdao=mens;
    }

    public void nuevoMensaje(String cuerpo, String asunto, Usuario remitente, List<Integer> recipientes){
        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(cuerpo);
        mensaje.setAsunto(asunto);
        mensaje.setRemitente(remitente);
        ArrayList<Usuario> listausuarios = new ArrayList<Usuario>();
        for(int i=0; i<recipientes.size(); i++){
            Usuario aux = new Usuario();
            aux.setId(recipientes.get(i));
            listausuarios.add(aux);
        }
        mensaje.setRecipientes(listausuarios);
        mensdao.save(mensaje);
    }
}
