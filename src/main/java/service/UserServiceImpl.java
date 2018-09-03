package service;

import api.UserService;
import dao.UserDaoImpl;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;
import entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    // == fields ==
    private static UserServiceImpl instance = null;
    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    // == constructors ==
    private UserServiceImpl() {
    }

    // == public methods ==
    public static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(User user) throws UserShortLengthPasswordException, UserLoginAlreadyExistException, UserShortLengthLoginException {
        if(userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    public void removeUserById(Long userId) {
        userDao.removeUserById(userId);
        }

}

