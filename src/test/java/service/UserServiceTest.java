package service;

import entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "admin", "admin"));
        users.add(new User(2L, "pablo", "admin"));

        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();

        assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser() {
        List<User> users = new ArrayList<>();
        User user = new User(1L, "admin", "admin");
        users.add(user);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();

        assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUser() {
        List<User> users = new ArrayList<>();
        User admin = new User(1L, "admin", "admin");
        User pablo = new User(2L, "pablo", "admin");
        users.add(admin);
        users.add(pablo);

        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1L);
        users.remove(admin);
        List<User> usersFromTestClass = userService.getAllUsers();

        assertEquals(users, usersFromTestClass);
    }
}
