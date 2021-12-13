package DAO;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import entity.Meal;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MealJpa implements MealDaoJpa{
    private final EntityManager em;

    @Override
    public int getMeal(String name) {
        TypedQuery<Meal> query = em.createQuery("select c from Meal c where c.name = :name", Meal.class);
        return query.setParameter("name", name).getSingleResult().getId();
    }

    @Override
    public Meal getMealById(int mealId) {
        return em.find(Meal.class, mealId);
    }

    @Override
    public void insertMeal(Meal meal) {
        em.getTransaction().begin();
        em.persist(meal);
        em.getTransaction().commit();
    }
}
