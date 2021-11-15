package services;

import DAO.MealDao;
import DAO.MealDaoImpl;
import DAO.MealLogDaoImpl;
import database.Queries;

public class UserService {

    public UserService(){}

    public void addNewMealToLog(String mealName, int userId){
        // Get id of meal from name
        MealDaoImpl mealDao = new MealDaoImpl();
        int mealId = mealDao.getMeal(mealName);

        // if no such meal then return error, else continue
        if (mealId == 0){
            return;
        }

        // add new write in meal_log
        MealLogDaoImpl mealLogDao = new MealLogDaoImpl();
        int flag = mealLogDao.insertMealLog(userId, mealId);

        if (flag==1){
            System.out.println("New meal added to meal log");
        } else {
            System.out.println("Error while adding meal to log");
        }

        return;
    }
}
