package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("XZ-2022");
        student.setAdmDate(LocalDate.of(2022, 4, 22));
        System.out.println("ФИО: " + student.getFio() + "\n"
                            + "Группа: " + student.getGroup() + "\n"
                            + "Дата поступления: " + student.getAdmDate());
    }
}
