package ru.job4j.tracker;

public interface Transport {
    void go();

    void passengers(int count);

    float refuel(float count);
}
