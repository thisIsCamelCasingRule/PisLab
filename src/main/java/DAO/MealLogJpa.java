package DAO;

import entity.MealLog;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MealLogJpa implements MealLogDaoJpa{
    private final EntityManager em;

    @Override
    public int insertMealLog(int userId, int mealId) {
        MealLog mealLog = new MealLog();
        mealLog.setMealId(mealId);
        mealLog.setUserId(userId);
        em.getTransaction().begin();
        em.persist(mealLog);
        em.getTransaction().commit();
        return 0;
    }

    @Override
    public List<Integer> getAllUserMeal(int userId) {
        TypedQuery<Integer> q = em.createQuery("select c.mealId from MealLog c where c.userId = :user_id", Integer.class);
        return q.setParameter("user_id", userId).getResultList();
    }
}
