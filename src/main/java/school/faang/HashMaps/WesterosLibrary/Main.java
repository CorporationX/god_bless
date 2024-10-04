package school.faang.HashMaps.WesterosLibrary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("Тарас Бульба", "Гоголь", 1835), "1");
        books.put(new Book("Ася", "Тургенев", 1858), "2");
        books.put(new Book("Ревизор", "Гоголь", 1836), "1");
        books.put(new Book("Гарри Поттер и узник Азкабана", "Роулинг", 1999), "3");
        books.put(new Book("Пиковая дама", "Пушкин", 1834), "2");

        addBook(new Book("Мастер и Маргарита", "Булгаков", 1967), "3");
        findBook("Ревизор", "Гоголь", 1836);
        removeBook("Ревизор", "Гоголь", 1836);
        getAllBooks();
    }

    public static void addBook(Book book, String place) {
        books.put(book, place);
    }

    public static void removeBook(String bookName, String author, int year) {
        books.remove(new Book(bookName, author, year));
    }

    public static void findBook(String bookName, String author, int year) {
        Book book = new Book(bookName, author, year);
        System.out.println(book + " на полке " + books.get(book));
    }

    public static void getAllBooks() {
        for (Book book : books.keySet()) {
            System.out.println(book.toString() + " находится на %s полке".formatted(books.get(book)));
        }
    }

}
