package Apirest.persistence;

import Apirest.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
public class UsuarioDAO extends GenericDao<Usuario> {


    public UsuarioDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<Usuario> getAll() {

        return null;
    }

    @Override
    public Usuario getById(int id) {

        return null;
    }

    @Override
    public void save(Usuario value) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(value);
        t.commit();
        session.close();
    }

    @Override
    void update(Usuario value) {

    }

    public Usuario getUsuario(String email, String password){
        Session session = this.sessionFactory.openSession();
        List<Usuario> list = session.createQuery("FROM Usuarios where email = :u and password = :p").setParameter("u",email).setParameter("p",password).list();
        session.close();
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
