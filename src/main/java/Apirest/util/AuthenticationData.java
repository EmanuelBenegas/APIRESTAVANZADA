package Apirest.util;
import Apirest.entities.Usuario;
import org.joda.time.DateTime;

/**
 * Created by lcc on 22/11/2016.
 */
public class AuthenticationData {
    private Usuario usuario;
    private DateTime lastAction;

    public DateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(DateTime lastAction) {
        this.lastAction = lastAction;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
