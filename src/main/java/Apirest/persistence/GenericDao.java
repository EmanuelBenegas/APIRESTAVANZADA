package Apirest.persistence;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lcc on 22/11/2016.
 */
public abstract class GenericDao<k> {
    protected SessionFactory sessionFactory;

    public GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    abstract List<k> getAll();
    abstract k getById(int id);
    abstract void save(k value);
    abstract void update(k value);
}
