package ru.job4j.inheritance;

import java.util.Date;

public class Builder extends Engineer {
    private String department;

    public Builder(String name, String surname, String education, Date birthday, String skills, String department) {
        super(name, surname, education, birthday, skills);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
