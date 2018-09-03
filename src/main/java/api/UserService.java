package api;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user) throws UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException;

    void removeUserById(Long user);

}
