package DAO;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserJpa implements UserDaoJpa{
    private final EntityManager em;
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select a from User a", User.class).getResultList();
    }

    @Override
    public User getUser(String username) {
        TypedQuery<User> query = em.createQuery("select c from User c where c.username = :username", User.class);
        return query.setParameter("username", username).getSingleResult();
    }

}
