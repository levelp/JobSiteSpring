package jobsite.dao;

import jobsite.account.AccountRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Тестирование работы с пользователями в БД
 */
public class UserDAOTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void aVoid() {

    }
}
