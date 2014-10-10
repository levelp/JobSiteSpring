package jobsite.dao.user;

import jobsite.model.Account;
import org.hibernate.Criteria;
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
        List<Account> listUser = (List<Account>) sessionFactory.getCurrentSession()
                .createCriteria(Account.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }
}