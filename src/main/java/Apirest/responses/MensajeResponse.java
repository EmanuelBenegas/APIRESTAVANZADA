package Apirest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lcc on 23/11/2016.
 */
public class MensajeResponse {
    @JsonProperty
    private int id_mensaje;
    @JsonProperty
    private String asunto;
    @JsonProperty
    private String cuerpo;
    @JsonProperty
    private UserResponse remitente;

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public UserResponse getRemitente() {
        return remitente;
    }

    public void setRemitente(UserResponse remitente) {
        this.remitente = remitente;
    }
}
