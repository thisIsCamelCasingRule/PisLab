import DAO.UserDao;
import DAO.UserDaoImpl;

import models.User;
import services.UserService;

import java.util.List;


public class Fattracker {
    public static void main(String[] args){

        UserService us = new UserService();
        us.addNewMealToLog("apple", 1);

        UserDaoImpl u = new UserDaoImpl();
        System.out.println(u.getAllUsers());
       // System.out.println(userList);




    }
}
