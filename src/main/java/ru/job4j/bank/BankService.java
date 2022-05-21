package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимаеи паспортные данные пользователя и производит по ним поиск
     * пользователя
     * @param passport паспортные данные пользователя
     * @return возвращает пользователя или null если не найден
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = users.keySet()
                .stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
        return rsl;
    }

    /**
     * Метод принимает паспортные данные и реквизиты счета и производит поиск
     * банковского счета
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает банковский счет или null если не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        boolean rsl = src.isPresent()
                && dest.isPresent()
                && src.get().getBalance() >= amount;
        if (rsl) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
        }
        return rsl;
    }
}