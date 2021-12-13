import entity.Meal;
import services.MealService;
import services.UserService;

import java.util.List;


public class Fattracker {
    public static void main(String[] args){
//        MealService ms = new MealService();
//        Meal meal = new Meal(2,"apple", 0, 0, 0, 0);
//        ms.addNewMeal(meal);
        // Юзер съел яблоко и добавил его в приложении
        UserService us = new UserService();
        us.addNewMealToLog("apple", 2);

        // Он захотел посмотреть что съел за сегодня (последние 24 часа)
        List<Meal> list = us.getUserMeal(2);

        System.out.println(list.toString());

    }
}
