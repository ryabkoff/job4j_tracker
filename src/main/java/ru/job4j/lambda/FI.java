package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);
        for (Attachment att : atts) {
            System.out.println(att);
        }
        String[] strings = {"a", "aa", "bb", "c", "ccc", "abcd"};
        Comparator<String> cmpSize = (left, right) -> Integer.compare(left.length(), right.length());
        Arrays.sort(strings, cmpSize);
        for (String str : strings) {
            System.out.println(str);
        }
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(strings, cmpText);
        for (String str : strings) {
            System.out.println(str);
        }
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(strings, cmpDescSize);
        for (String str : strings) {
            System.out.println(str);
        }
    }

}