package dao;

import model.User;

import java.util.Set;

public interface UserDao {
     void  saveUser (User user);
     void deleteUser (Long userId);
     User getUserByLogin (String login);
     User getUseByEmail (String email);
     Set<User> getFollows (String login);
     Set<User> getFollowers (String login);
     Set<User> getNotFollowedUsers(String login);




}
