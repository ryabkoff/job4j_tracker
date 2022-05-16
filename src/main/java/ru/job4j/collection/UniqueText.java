package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        String[] originArray = originText.split(" ");
        for (String element : originArray) {
            check.add(element);
        }
        String[] duplicateArray = duplicateText.split(" ");
        for (String element : duplicateArray) {
            if (!check.contains(element)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}