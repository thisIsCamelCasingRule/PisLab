import DAO.MealDaoImpl;
import DAO.UserDao;
import DAO.UserDaoImpl;

import models.Meal;
import models.User;
import services.UserService;

import java.util.List;


public class Fattracker {
    public static void main(String[] args){
        // Юзер съел яблоко и добавил его в приложении
        UserService us = new UserService();
        us.addNewMealToLog("apple", 1);


//        UserDaoImpl u = new UserDaoImpl();
//        System.out.println(u.getAllUsers());

        // Он захотел посмотреть что съел за сегодня (последние 24 часа)
        List<Meal> list = us.getUserMeal(1);

        System.out.println(list.toString());
       // System.out.println(userList);




    }
}
