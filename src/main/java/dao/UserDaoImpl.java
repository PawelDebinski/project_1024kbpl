package dao;

import api.UserDao;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    // == fields ==
    String fileName;

    // == constructors ==
    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    // == public methods ==
    @Override
    public void saveUser(User user) {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(fileName, true))) {
            pw.write(user.toString() + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
    }

    @Override
    public void saveUsers(List<User> users) {
        try(PrintWriter pw = new PrintWriter( new FileOutputStream(fileName, false))) {
            for(User user : users) {
                pw.write(user.toString() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try(BufferedReader bw = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = bw.readLine()) != null) {
                String[] array = line.split(",");
                User user = new User(Long.parseLong(array[0]), array[1], array[2]);
                userList.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
        return userList;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = getAllUsers();
        for(User user : userList) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userId) {
        List<User> userList = getAllUsers();
        for(User user : userList) {
            if(user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) {
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
    public void removeUserById(Long id) {
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
