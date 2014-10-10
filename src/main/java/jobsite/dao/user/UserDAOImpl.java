package jobsite.dao.user;

import jobsite.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация UserDAO
 */
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Account> list() {
        @SuppressWarnings("unchecked")
        List<Account> listUser = sessionFactory.getCurrentSession()
                .createQuery("from Account", Account.class)
                .list();
        return listUser;
    }
}