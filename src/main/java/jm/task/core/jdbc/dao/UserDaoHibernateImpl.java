package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction ta = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ta = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users" +
                    " (id mediumint not null auto_increment, name VARCHAR(45), " +
                    "lastname VARCHAR(45), " +
                    "age tinyint, " +
                    "PRIMARY KEY (id))").executeUpdate();
            ta.commit();
        } catch (Exception e) {
            if (ta != null) {
                ta.rollback();
            }
        } finally {
            session.close();
        }
    }


    @Override
    public void dropUsersTable() {
        Transaction ta = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ta = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
            ta.commit();
        } catch (Exception e) {
            if (ta != null) {
                ta.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction ta = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ta = session.beginTransaction();
            session.save(new User(name, lastName, age));
            ta.commit();
        } catch (Exception e) {
            if (ta != null) {
                ta.rollback();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public void removeUserById(long id) {
        Transaction ta = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ta = session.beginTransaction();
            session.delete(session.get(User.class, id));
            ta.commit();
        } catch (Exception e) {
            if (ta != null) {
                ta.rollback();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction ta = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            ta = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
            ta.commit();
        } catch (Exception e) {
            if (ta != null) {
                ta.rollback();
            }
        } finally {
            session.close();
        }

    }
}
