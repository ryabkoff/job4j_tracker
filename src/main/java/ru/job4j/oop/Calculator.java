package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println("sum: " + sum(5));
        Calculator calc = new Calculator();
        System.out.println("multiply: " + calc.multiply(5));
        System.out.println("minus: " + minus(5));
        System.out.println("divide: " + calc.divide(5));
        System.out.println("sumAllOperation: " + calc.sumAllOperation(5));
     }
}