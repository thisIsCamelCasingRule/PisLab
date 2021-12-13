package DAO;

import entity.Meal;

public interface MealDaoJpa {
    public int getMeal(String name);
    public Meal getMealById(int mealId);
    public void insertMeal(Meal meal);
}
