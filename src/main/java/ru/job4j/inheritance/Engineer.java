package ru.job4j.inheritance;

import java.util.Date;

public class Engineer extends Profession {
    private String skills;

    public Engineer(String name, String surname, String education, Date birthday, String skills) {
        super(name, surname, education, birthday);
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }
}
