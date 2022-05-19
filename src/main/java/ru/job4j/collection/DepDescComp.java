package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int o1SlashPos = o1.indexOf("/");
        int o2SlashPos = o2.indexOf("/");
        String firstPartO1 = o1SlashPos > 0 ? o1.substring(0, o1SlashPos) : o1;
        String secondPartO1 = o1SlashPos > 0 ? o1.substring(o1SlashPos + 1) : "";
        String firstPartO2 = o2SlashPos > 0 ? o2.substring(0, o2SlashPos) : o2;
        String secondPartO2 = o2SlashPos > 0 ? o2.substring(o2SlashPos + 1) : "";
        int rsl = firstPartO2.compareTo(firstPartO1);
        if (rsl == 0) {
            rsl = secondPartO1.compareTo(secondPartO2);
        }
        return rsl;
    }
}
