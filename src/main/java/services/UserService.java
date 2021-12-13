package services;

import DAO.*;
import entity.Meal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserService(){}

    public void addNewMealToLog(String mealName, int userId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MealDaoJpa mealDao = new MealJpa(entityManager);

        // Get id of meal from name
        int mealId = mealDao.getMeal(mealName);

        // if no such meal then return error, else continue
        if (mealId == 0){
            return;
        }

        // add new write in meal_log
        EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager2 = entityManagerFactory2.createEntityManager();
        MealLogDaoJpa mealLogDao = new MealLogJpa(entityManager2);

        int flag = mealLogDao.insertMealLog(userId, mealId);

        if (flag==1){
            System.out.println("New meal added to meal log");
        } else {
            System.out.println("Error while adding meal to log");
        }
    }

    public List<Meal> getUserMeal(int userID){
        EntityManagerFactory entityManagerFactory2 = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager2 = entityManagerFactory2.createEntityManager();
        MealLogDaoJpa mealLogDao = new MealLogJpa(entityManager2);

        List<Meal> mealList = new ArrayList<>();

        // Get list of meal ids that user has in meal_log
        List<Integer> mealIdList = mealLogDao.getAllUserMeal(userID);

        // find the meal in db and parse it to meal list
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MealDaoJpa mealDao = new MealJpa(entityManager);

        for(int i = 0; i < mealIdList.size(); i++){
            Meal tmpm = mealDao.getMealById(mealIdList.get(i));
            mealList.add(tmpm);
        }
        // return meal list
        return mealList;
    }
}
