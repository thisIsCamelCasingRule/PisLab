package services;

import DAO.MealDaoJpa;
import DAO.MealJpa;
import entity.Meal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MealService {
    public void addNewMeal(Meal meal){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MealDaoJpa mealDao = new MealJpa(entityManager);

        mealDao.insertMeal(meal);
    }
}
