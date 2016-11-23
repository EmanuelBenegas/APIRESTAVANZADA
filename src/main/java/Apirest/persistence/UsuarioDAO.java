package Apirest.persistence;

import Apirest.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
@Repository
public class UsuarioDAO extends GenericDao<Usuario> {


    public UsuarioDAO(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    public List<Usuario> getAll() {
        Session session = this.sessionFactory.openSession();
        List<Usuario> usuarios = session.createQuery("FROM Usuario").list();
        session.close();
        return usuarios;
    }

    @Override
    public Usuario getById(int id) {
        Session session = this.sessionFactory.openSession();
        Usuario user = (Usuario) session.get(Usuario.class, id);
        session.close();
        return user;
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
        List<Usuario> list = session.createQuery("FROM Usuario where email = :u and password = :p").setParameter("u",email).setParameter("p",password).list();
        session.close();
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
