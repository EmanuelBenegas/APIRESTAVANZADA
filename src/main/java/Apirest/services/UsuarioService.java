package Apirest.services;

import Apirest.entities.Usuario;
import Apirest.persistence.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lcc on 22/11/2016.
 */
@Service
public class UsuarioService {

    UsuarioDAO userdao;

    @Autowired
    public UsuarioService(UsuarioDAO userdao){

        this.userdao=userdao;
    }

    public void nuevoUser(Usuario user){
        try{
            userdao.save(user);
        }
        catch (Exception e){

        }
    }
}
