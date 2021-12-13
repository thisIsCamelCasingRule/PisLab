package database;

import models.Meal;

public class MealQueries {

    public MealQueries(){}

    public String getAllMeal() {
        return "SELECT * FROM Meal";
    }

    public String getMealById(int mealId) {
        return "SELECT * FROM Meal where id = "+ mealId;
    }

    public String insertMeal(Meal m){
        return "INSERT INTO Meal(name, calories, fats, proteins, carbohydrates) VALUES('" + m.getName() + "'," + m.getCalories()+","+m.getFats()+","+m.getProteins()+","+m.getCarbohydrates()+")";
    }

    public String deleteMeal(Meal m){
        return "DELETE FROM Meal WHERE id = " + m.getId();
    }

    public String updateMeal(Meal m){
        return "UPDATE User SET name = '"+m.getName()+"', calories = "+m.getCalories()+", fats = "+m.getFats()+", proteins = "+m.getProteins()+", carbohydrates = "+m.getCarbohydrates();
    }

    public String getMealByName(String uname){
        return "SELECT id FROM Meal WHERE name = '"+uname+"'";
    }

}
