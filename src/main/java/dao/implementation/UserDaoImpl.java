package dao.implementation;

import dao.AbstractDao;
import dao.UserDao;
import model.User;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDaoImpl extends AbstractDao implements UserDao {
    @Override
    public void saveUser(User user) {
        hibernateConfig.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        hibernateConfig.delete(User.class, userId);
    }

    @Override
    public User getUserByLogin(String login) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login =:login", User.class);
        return query.setParameter("login", login).getSingleResult();
    }

    @Override
    public User getUseByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("select  u from User u where u.email =:email" , User.class);
        return query.setParameter("email" , email).getSingleResult();

    }

    @Override
    public Set<User> getNotFollowedUsers(String login) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u != " + login, User.class).getResultList();
        Set<User> followedUser = getFollowers(login);
        users.removeAll(followedUser);
        users.remove(login);
        return new HashSet<User>(users);
    }

    @Override
    public Set<User> getFollows(String login) {
      return getUserByLogin(login).getFollows();
    }

    @Override
    public Set<User> getFollowers(String login) {
       return getUserByLogin(login).getFollowers();
    }


}
