package Apirest.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by lcc on 21/11/2016.
 */
@Entity
@Table(name = "Mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario remitente;
    private Date fecha;
    private String mensaje;
    private String asunto;
    @ManyToMany
    @JoinTable(name = "User_Mensaje",
            joinColumns = @JoinColumn(name = "id_mensaje"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> recipientes;

    public Mensaje(){

    }

    public Mensaje(Usuario remitente, Date fecha, String mensaje, String asunto, List<Usuario> recipientes){
        this.setRemitente(remitente);
        this.setFecha(fecha);
        this.setMensaje(mensaje);
        this.setAsunto(asunto);
        this.setRecipientes(recipientes);
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @Column(name = "Mensaje", length = 400)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    @Column(name = "Asunto", length = 25)
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public List<Usuario> getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(List<Usuario> recipientes) {
        this.recipientes = recipientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
