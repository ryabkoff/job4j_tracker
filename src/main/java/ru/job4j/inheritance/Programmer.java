package ru.job4j.inheritance;

import java.util.Date;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, Date birthday, String skills, String lang) {
        super(name, surname, education, birthday, skills);
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
