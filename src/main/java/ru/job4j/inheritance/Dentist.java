package ru.job4j.inheritance;

import java.util.Date;

public class Dentist extends Doctor {
    boolean orthopedist;

    public Dentist(String name, String surname, String education, Date birthday, String hospital, boolean orthopedist) {
        super(name, surname, education, birthday, hospital);
        this.orthopedist = orthopedist;
    }

    public boolean isOrthopedist() {
        return orthopedist;
    }
}
