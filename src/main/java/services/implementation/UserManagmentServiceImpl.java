package services.implementation;

import dao.UserDao;
import dao.implementation.UserDaoImpl;
import model.User;
import services.UserManagmentService;

import javax.persistence.NoResultException;
import java.util.Set;

public class UserManagmentServiceImpl implements UserManagmentService {

    private UserDao userDao;

    public UserManagmentServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
    userDao.deleteUser(userId);
    }

    @Override
    public void follow(String currentUserLogin, String userLoginToFollow) {
        User currentUser = userDao.getUserByLogin(currentUserLogin);
        User userToFollow = userDao.getUserByLogin(userLoginToFollow);
        currentUser.getFollows().add(userToFollow);
        saveUser(currentUser);
    }

    @Override
    public void stopFollowing(String currentUserLogin, String userLoginToFollow) {
        User currentUser = userDao.getUserByLogin(currentUserLogin);
        User userToFollow = userDao.getUserByLogin(userLoginToFollow);
        currentUser.getFollows().remove(userToFollow);
        saveUser(currentUser);
    }


    @Override
    public boolean isUserValid(String login, String password) {
        try {
            return userDao.getUserByLogin(login).getPassword().equals(password);
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public boolean isUserExists(String login) {
        try {
            userDao.getUserByLogin(login);
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isEmailExists(String email) {
        try {
            userDao.getUseByEmail(email);
        } catch (NoResultException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validationUserLoginAndPassword(String login, String password) {
        User user = userDao.getUserByLogin(login);
        return user.getPassword().equals(password);
    }


    @Override
    public Set<User> getNotFollowedUsers(String login) {
        return userDao.getNotFollowedUsers(login);
    }
}
