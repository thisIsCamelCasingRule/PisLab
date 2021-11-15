package DAO;

import models.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUser(String username);
    public void updateUser(User u);
    public void deleteUser(User u);
    public void insertUser(User u);
}
