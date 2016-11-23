package Apirest.persistence;
import Apirest.entities.Mensaje;
import Apirest.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
@Repository
public class MensajeDAO extends GenericDao<Mensaje>{


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

        return null;
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
}
