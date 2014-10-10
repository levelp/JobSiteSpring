package jobsite.account;

import jobsite.model.Account;
import org.jboss.logging.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Repository
@Transactional(readOnly = true)
public class AccountRepository {
    Logger LOG = Logger.getLogger(AccountRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Account save(Account account) {
        // Шифрование пароля
        String password = account.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        LOG.info(password + " -> " + encodedPassword);
        account.setPassword(encodedPassword);
        entityManager.persist(account);
        return account;
    }

    public Account findByEmail(String email) {
        try {
            return entityManager.createNamedQuery(Account.FIND_BY_EMAIL, Account.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (PersistenceException e) {
            return null;
        }
    }


}
