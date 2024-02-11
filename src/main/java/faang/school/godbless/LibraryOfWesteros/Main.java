package faang.school.godbless.LibraryOfWesteros;

import faang.school.godbless.GameOfThrones.House;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookLocation = new HashMap<>();
        bookLocation.put(new Book("Мятная сказка", "Полярный", 2000), "Первая");
        bookLocation.put(new Book("Другая сторона", "Радион Кораблев", 2000), "Вторая");
        bookLocation.put(new Book("Кафе на краю земли", "Джона П. Стрелеки", 2002), "Первая");
        addBooks(bookLocation, "Четвертая", "Тонкое искусство пофигизма", "Марк Мэнсон", 2016);
        System.out.println("Добавили книгу");
        printAllBooks(bookLocation);
        removeBook(bookLocation, "Другая сторона", "Радион Кораблев", 2000);
        System.out.println("Удалили книгу");
        printAllBooks(bookLocation);
        findBooksLocation(bookLocation, "Кафе на краю земли", "Джона П. Стрелеки", 2002);
    }

    public static void addBooks(Map<Book, String> bookLocation, String location, String title, String author, int year) {
        bookLocation.put(new Book(title, author, year), location);
    }

    //загугли как перезаписываются данные!!!
    public static void removeBook(Map<Book, String> bookLocation, String title, String author, int year) {
        bookLocation.remove(new Book(title, author, year));
    }

    public static void findBooksLocation(Map<Book, String> bookLocation, String title, String author, int year) {
        String location = bookLocation.get(new Book(title, author, year)).toString();
        if (location != null) System.out.println("Нахождение книги: " + location + " полка");
    }

    public static void printAllBooks(Map<Book, String> bookLocation) {
        for (Map.Entry<Book, String> entry : bookLocation.entrySet()) {
            System.out.println(String.format("Title: %s, Author: %s, Year: %d, Location: %s полка", entry.getKey().getTitle(), entry.getKey().getAuthor(), entry.getKey().getYear(), entry.getValue()));
        }
    }
}
