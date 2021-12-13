package DAO;

import entity.User;

import java.util.List;


public interface UserDaoJpa {
    public List<User> getAllUsers();
    public User getUser(String username);
}
