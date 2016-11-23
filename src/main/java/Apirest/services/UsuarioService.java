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

    public void Usernew(String nombre,
                          String apellido,
                          String direccion,
                          String telefono,String ciudad, String provincia,String pais, String email, String password){
        Usuario user = new Usuario();
        try{
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setDireccion(direccion);
            user.setTelefono(telefono);
            user.setCiudad(ciudad);
            user.setProvincia(provincia);
            user.setPais(pais);
            user.setEmail(email);
            user.setPassword(password);
            userdao.save(user);
        }
        catch (Exception e){

        }
    }

    public Usuario getUserforLogin(String email, String password){
        return userdao.getUsuario(email,password);
    }


}
