import DAO.UserDao;
import DAO.UserDaoImpl;
import database.Database;
import database.UserQueries;
import models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Fattracker {
    public static void main(String[] args){

        UserDao d = new UserDaoImpl();
        List<User> userList = d.getAllUsers();
        System.out.println(userList);




    }
}
