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
    @Autowired
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

    public List<Mensaje> getEntrada(String email){
        List<Mensaje> entrada=null;
        try{
            entrada=mensdao.getEntrada(email);
        }
        catch (Exception e){

        }
        finally {
            return entrada;
        }
    }

    public List<Mensaje> getSalida(String email){
        List<Mensaje> listasalida = null;
        try{
            listasalida = mensdao.getSalida(email);
        }
        catch (Exception e){

        }
        finally {
            return listasalida;
        }
    }

    public Mensaje getUno(int id){
        return mensdao.getById(id);
    }

    public Mensaje getUnoSalida(int id_user, int idmensaje){
        Mensaje m =null;
        try {
            m = mensdao.getUnoSalida(id_user,idmensaje);
            return m;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return m;
        }
    }

    public Mensaje getUnoEntrada(String email, int idmensaje){
        Mensaje m = null;
        try {
            m = mensdao.getUnoEntrada(email,idmensaje);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            return m;
        }
    }


}
