package jobsite.dao.user;

import jobsite.account.Account;

import java.util.List;

/**
 * Класс для работы с пользователями в Базе Данных
 */
public interface UserDAO {
    public List<Account> list();
}
