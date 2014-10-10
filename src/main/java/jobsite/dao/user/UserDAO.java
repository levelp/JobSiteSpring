package jobsite.dao.user;

import jobsite.model.Account;

import java.util.List;

/**
 * Класс для работы с пользователями в Базе Данных
 */
public interface UserDAO {
    public List<Account> list();
}
