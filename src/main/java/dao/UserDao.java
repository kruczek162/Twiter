package dao;

import model.User;

import java.util.Set;

public interface UserDao {
    public void  saveUser (User user);
    public void deleteUser (Long userId);
    public User getUserByLogin (String login);
    public User getUseByEmail (String email);
    public Set<User> getFollows (String login);
    public Set<User> getFollowers (String login);
    public Set<User> getNotFollowedUsers(String login);




}
