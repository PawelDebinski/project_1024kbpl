package api;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    boolean addUser(User user);

    void removeUserById(Long user) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(Long id) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);





}
