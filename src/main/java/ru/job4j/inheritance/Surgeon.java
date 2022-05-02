package ru.job4j.inheritance;

import java.util.Date;

public class Surgeon extends Doctor {
    private String specialization;

    public Surgeon(String name, String surname, String education, Date birthday, String hospital, String specialization) {
        super(name, surname, education, birthday, hospital);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
