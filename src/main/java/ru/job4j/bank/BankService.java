package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 *  * @author SERGEY RYABKOV
 *  * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции типа Map
     * Ключ пользователь, значени список счетов тип List
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя, если такого пользователя еще нет,
     * добавляет его в карту в качестве ключа, и создает пустой список счетов
     * @param user пользователь, который добавляется в карту
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспортные данные пользователя находит
     * по ним пользователя и добавляет банковский счет
     * @param passport паспортные данные пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает паспортные данные и реквизиты счета и производит поиск
     * банковского счета
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает банковский счет или null если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает паспортные данные и реквизиты счета источника и приемника.
     * Производит поиск их в карте, списание суммы с источника и зачисление приемнику.
     * @param srcPassport паспортные данные пользователя с которого будет списана сумма
     * @param srcRequisite реквизиты банковского счета с которого будет списана сумма
     * @param destPassport паспортные данные пользователя на которого будет зачислена сумма
     * @param destRequisite еквизиты банковского счета на который будет зачислена сумма
     * @param amount сумма, которая будет списана с src и зачислена на desc
     * @return возвращает true в случае успешной операции и false в случае неудачи
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        boolean rsl = src != null
                && dest != null
                && src.getBalance() >= amount;
        if (rsl) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return rsl;
    }
}