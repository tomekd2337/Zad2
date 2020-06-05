package pl.jaz.jazapp.service;

import pl.jaz.jazapp.dao.UserDao;
import pl.jaz.jazapp.exceptions.UserDoesNotExistException;
import pl.jaz.jazapp.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {
    @EJB
    private UserDao userDao;

    public void createUser(User user) {
        this.userDao.createUser(user);
    }

    public User getUserByLogin(String userName) throws UserDoesNotExistException {
        return this.userDao.getUserByLogin(userName);
    }
}
