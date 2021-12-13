package DAO;

import java.util.List;

public interface MealLogDaoJpa {
    public int insertMealLog(int userId, int mealId);
    public List<Integer> getAllUserMeal(int userId);
}
