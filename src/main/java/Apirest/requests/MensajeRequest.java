package Apirest.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by lcc on 23/11/2016.
 */
public class MensajeRequest {
    @JsonProperty("id")
    private Integer idMensaje;
    @JsonProperty("remitente")
    private Integer remitente;
    @JsonProperty("asunto")
    private String asunto;
    @JsonProperty("cuerpomensaje")
    private String cuerpomensaje;
    @JsonProperty("recipientes")
    private ArrayList<Integer> recipientes;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Integer getRemitente() {
        return remitente;
    }

    public void setRemitente(Integer remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public ArrayList<Integer> getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(ArrayList<Integer> recipientes) {
        this.recipientes = recipientes;
    }

    public String getCuerpomensaje() {
        return cuerpomensaje;
    }

    public void setCuerpomensaje(String cuerpomensaje) {
        this.cuerpomensaje = cuerpomensaje;
    }
}
