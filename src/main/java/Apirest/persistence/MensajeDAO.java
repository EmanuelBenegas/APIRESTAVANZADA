package Apirest.persistence;
import Apirest.entities.Mensaje;
import Apirest.entities.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
@Repository
public class MensajeDAO extends GenericDao<Mensaje>{
    @Autowired
    private UsuarioDAO userdao;

    public MensajeDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<Mensaje> getAll() {
        Session session = this.sessionFactory.openSession();
        List<Mensaje> mensajes = session.createQuery("FROM Mensaje").list();
        session.close();
        return mensajes;
    }

    @Override
    public Mensaje getById(int id) {
        Session session = null;
        Mensaje m = null;
        try{
            session = this.sessionFactory.openSession();
            //m = (Mensaje) session.createQuery("from Mensaje where id = :u").setParameter("u",id);
            m = (Mensaje)session.get(Mensaje.class,id);

        }
        catch (Exception e){

        }
        finally {
            session.close();
            return m;
        }
    }

    @Override
    public void save(Mensaje value) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(value);
        t.commit();
        session.close();
    }

    @Override
    public void update(Mensaje value) {

    }

    public List<Mensaje> getEntrada(String email) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createSQLQuery("SELECT m.* from usuarios u INNER JOIN user_mensaje um on u.id = um.id_usuario " +
                    "INNER JOIN mensajes m on m.id = um.id_mensaje where u.email = :comprobante").addEntity(Mensaje.class).setParameter("comprobante",email);
            List<Mensaje> listaentrada = query.list();
            return listaentrada;
        }
        catch (Exception e){
            throw e;
        }
        finally {
            session.close();
        }
    }

    public List<Mensaje> getSalida(String email) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            Usuario u = userdao.getUsuariobyEmail(email);
            List<Mensaje> listasalida = session.createSQLQuery("Select * from Mensajes where id_usuario = :iduser").addEntity(Mensaje.class).setParameter("iduser",u.getId()).list();
            return listasalida;
        }
        catch (Exception e){
            throw e;
        }
        finally {
            session.close();
        }
    }

    public Mensaje getUnoSalida(int id_user, int id_mensaje) throws Exception {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            Query query = session.createSQLQuery("Select * from Mensajes where id = :idmensaje and id_usuario = :iduser").addEntity(Mensaje.class).setParameter("idmensaje",id_mensaje).setParameter("iduser",id_user);
            List<Mensaje> lista = query.list();
            if (lista.size() == 1) {
                return lista.get(0);
            } else {
                return null;
            }
        }
        catch (Exception e){
            throw e;
        }
        finally {
            session.close();
        }
    }

    public Mensaje getUnoEntrada(String email, int id_mensaje) throws Exception{
        Session session = null;
        try{
            session = this.sessionFactory.openSession();
            Query query = session.createSQLQuery("SELECT m.* from usuarios u INNER JOIN user_mensaje um on u.id = um.id_usuario " +
                    "INNER JOIN mensajes m on m.id = um.id_mensaje where u.email = :comprobante and m.id = :idmens").addEntity(Mensaje.class).setParameter("comprobante",email).setParameter("idmens",id_mensaje);
            List<Mensaje> lista = query.list();
            if (lista.size() == 1) {
                return lista.get(0);
            } else {
                return null;
            }
        }
        catch (Exception e){
            throw e;
        }
        finally {
            session.close();
        }
    }
}
