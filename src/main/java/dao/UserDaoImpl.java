package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    // == constants ==
    public static final String FILE_NAME = "users.txt";

    // == fields ==
    private static UserDaoImpl instance = null;

    // == constructors ==
    private UserDaoImpl() {
    }

    // == public methods ==
    public static UserDaoImpl getInstance() {
        if(instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(FILE_NAME, false))) {
            for(User user : users) {
                pw.write(user.toString() + "\n");
            }
        }
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> userList = new ArrayList<>();

        try(BufferedReader bw = new BufferedReader(new FileReader(FILE_NAME))) {
            String nextLine;
            while((nextLine = bw.readLine()) != null) {
                User user = UserParser.StringToUser(nextLine);
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> userList = getAllUsers();

        for(User user : userList) {
            if(user.getLogin().equals(login)) {
                userList.remove(user);
                saveUsers(userList);
                break;
            }
        }
    }

    @Override
    public void removeUserById(Long id) throws IOException {
        List<User> userList = getAllUsers();

        for(User user : userList) {
            if(user.getId().equals(id)) {
                userList.remove(user);
                saveUsers(userList);
                break;
            }
        }
    }
}
