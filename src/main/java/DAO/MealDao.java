package DAO;

import models.Meal;
import models.User;

import java.util.List;

public interface MealDao {
    public List<Meal> getAllUserMeal(int userId);
    public Meal getMeal(String username);
    public void updateUser(User u);
    public void deleteUser(User u);
    public void insertUser(User u);
}
