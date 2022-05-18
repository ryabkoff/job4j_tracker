package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int index = 0; index < Math.max(left.length(), right.length()); index++) {
            rsl = ((index < left.length()) ? left.charAt(index) : 0)
                    - ((index < right.length()) ? right.charAt(index) : 0);
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}