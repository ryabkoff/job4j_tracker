package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("English grammar");
        book1.setCountPages(500);
        Book book2 = new Book();
        book2.setName("Lyrical poems");
        book2.setCountPages(300);
        Book book3 = new Book();
        book3.setName("Clean code");
        book3.setCountPages(464);
        Book book4 = new Book();
        book4.setName("Lord of the rings");
        book4.setCountPages(1000);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ", " + books[i].getCountPages() + " pages");
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ", " + books[i].getCountPages() + " pages");
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + ", " + books[i].getCountPages() + " pages");
            }
        }

    }
}
