package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int res = second[0].compareTo(first[0]);
        return res == 0 ? o1.compareTo(o2) : res;
    }
}
