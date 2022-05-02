package ru.job4j.oop;

public class Battery {
    private int load;

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load += load;
        load = 0;
    }

    public Battery(int load) {
        this.load = load;
    }
}
