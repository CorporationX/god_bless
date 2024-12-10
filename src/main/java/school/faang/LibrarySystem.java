package school.faang;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        books.put(book, location);
        System.out.println("Книга '" + book.getTitle() + "' добавлена на " + location + "-ю полку.");
    }

    public static void removeBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            books.remove(book);
            System.out.println("Книга '" + book.getTitle() + "' удалена.");
        } else {
            System.out.println("Такой книги нет в библиотеке!");
        }
    }

    public static void findBook(String title, String author, int year, Map<Book, String> books) {
        Book book = new Book(title, author, year);
        if (books.get(book) != null) {
            System.out.println("Книга '" + book.getTitle() + "' лежит на " + books.get(book) + "-й полке.");
        } else {
            System.out.println("Книга '" + book.getTitle() + " не найдена!");
        }
    }

    public static void printAllBooks(Map<Book, String> books) {
        System.out.println("\nСписок всех книг в библиотеке:");
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println(entry.getKey().toString() + "лежит на " + entry.getValue() + "-й полке.");
        }
    }
}
