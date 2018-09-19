package service;

import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import validator.UserValidator;

import java.io.IOException;
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

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isLoginAlreadyExist(String login) throws IOException {
        User user = getUserByLogin(login);

        return user != null;
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
        }

    @Override
    public User getUserById(Long id) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users
        ) {
            boolean isFoundUser = user.getId().equals(id);
            if (isFoundUser) {
                return user;
            }

        }

        return null;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users
            ) {
                boolean isFoundUser = user.getLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) throws IOException {
        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPass = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }

}

