package com.map.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Мёртвые души", "Гоголь Николай Васильевич", 1842);
        Book book2 = new Book("Идиот", "Достоевский Фёдор Михайлович", 1868);
        Book book3 = new Book("Граф Монте-Кристо", "Дюма Александр", 1845);

        bookMap.put(new Book("Мёртвые души", "Гоголь Николай Васильевич", 1842), "1");
        bookMap.put(new Book("Идиот", "Достоевский Фёдор Михайлович", 1868), "2");

        searchBookByName("Идиот");
        System.out.println();
        searchBookByAuthor("Гоголь Николай Васильевич");
        System.out.println();
        searchBookByYear(1842);
        System.out.println();
        deleteBooKByName("Мёртвые души");
        System.out.println();
        addBook(book3, "3");
        listBook();

    }

    public static void addBook(Book book, String shelfNumber) {
        bookMap.put(book, shelfNumber);
    }

    public static void deleteBooKByName(String name) {
        bookMap.entrySet().removeIf(entry -> entry.getKey().getTitle().equals(name));

    }

    public static void deleteBooKByAuthor(String author) {
        bookMap.entrySet().removeIf(entry -> entry.getKey().getAuthor().equals(author));
    }

    public static void deleteBooKByYear(int year) {
        bookMap.entrySet().removeIf(entry -> entry.getKey().getYear() == year);
    }

    public static void searchBookByName(String name) {
        bookMap.forEach((k, v) -> {
            if (k.getTitle().equals(name)) {
                System.out.println(k + ": shelf number " + v);
            }
        });
    }

    public static void searchBookByAuthor(String author) {
        bookMap.forEach((k, v) -> {
            if (k.getAuthor().equals(author)) {
                System.out.println(k + ": shelf number " + v);
            }
        });
    }

    public static void searchBookByYear(int year) {
        bookMap.forEach((k, v) -> {
            if (k.getYear() == year) {
                System.out.println(k + ": shelf number " + v);
            }
        });
    }

    public static void listBook() {
        bookMap.forEach((k, v) -> System.out.println(k + ": shelf number " + v));
    }

}
