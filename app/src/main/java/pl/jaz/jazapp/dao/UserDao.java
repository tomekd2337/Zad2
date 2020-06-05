package pl.jaz.jazapp.dao;

import pl.jaz.jazapp.exceptions.UserDoesNotExistException;
import pl.jaz.jazapp.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao {
    @PersistenceContext(name="default")
    private EntityManager em;

    public void createUser(User user) {
        em.persist(user);
    }

    public User getUserByLogin(String userName) throws UserDoesNotExistException {
        try {
            return em.createQuery("FROM User WHERE login = :login", User.class)
                    .setParameter("login", userName)
                    .getSingleResult();
        } catch (NoResultException ex) {
            throw new UserDoesNotExistException(ex);
        }
    }
}
