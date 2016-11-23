package Apirest.conversores;

import Apirest.entities.Usuario;
import Apirest.responses.UserResponse;

/**
 * Created by lcc on 23/11/2016.
 */
public class UsuarioConversor {



    public UserResponse conversor(Usuario user){
        UserResponse ur = new UserResponse();
        ur.setNombre(user.getNombre());
        ur.setApellido(user.getApellido());
        ur.setDireccion(user.getDireccion());
        ur.setTelefono(user.getTelefono());
        ur.setCiudad(user.getCiudad());
        ur.setProvincia(user.getProvincia());
        ur.setPais(user.getPais());
        ur.setEmail(user.getEmail());
        ur.setPassword(user.getPassword());
        return ur;
    }
}
