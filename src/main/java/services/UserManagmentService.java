package services;

import model.User;
import java.util.Set;

public interface UserManagmentService {
    void  saveUser(User user);
    void deleteUser(Long userId);
    void follow(String currentUserLogin, String userLoginToFollow);
    void stopFollowing(String currentUserLogin, String userLoginToFollow);
    Set<User> getNotFollowedUsers(String login);
    boolean isUserValid(String login, String password);
    boolean isUserExists(String login);
    public boolean isEmailExists(String email);
    boolean validationUserLoginAndPassword(String login, String password);
    Set<User> getFollowedPUsers (String login);


}
