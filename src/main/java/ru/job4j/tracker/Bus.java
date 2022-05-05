package ru.job4j.tracker;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Tr-tr-tr");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Passengers: " + count);
    }

    @Override
    public float refuel(float count) {
        float price = 45.5F;
        return price;
    }
}
