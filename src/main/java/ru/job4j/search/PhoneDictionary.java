package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = s -> key.equals(s.getName());
        Predicate<Person> compareSurname = s -> key.equals(s.getSurname());
        Predicate<Person> comparePhone = s -> key.equals(s.getPhone());
        Predicate<Person> compareAddress = s -> key.equals(s.getAddress());
        Predicate<Person> combine = compareName.or(compareSurname).
                or(comparePhone).
                or(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}