package school.faang.westeros.library;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        checkArguments(title, author, year, location);
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.println("Книга " + book + " добавлена на полку " + location);
    }

    public void removeBook(String title, String author, int year) {
        checkArguments(title, author, year);
        Book book = new Book(title, author, year);
        String location = library.remove(book);
        if (location != null) {
            System.out.println("Книга " + book + " удалена с полки " + location);
            return;
        }
        System.out.println("Книга " + book + " для удаления не найдена.");
    }

    public void findBook(String title, String author, int year) {
        checkArguments(title, author, year);
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location == null) {
            System.out.println("Книга " + book + " не найдена.");
            return;
        }
        System.out.println("Книга " + book + " находится на полке " + location);
    }

    public void printAllBooks() {
        System.out.println("\nСписок книг:");
        for (Map.Entry entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey() + "\tПолка: " + entry.getValue());
        }
    }

    private void checkArguments(String title, String author, int year) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым!");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("Имя автора должно быть заполнено!");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Указан некорректный год издания!");
        }
    }

    private void checkArguments(String title, String author, int year, String location) {
        checkArguments(title, author, year);
        if (location.isBlank()) {
            throw new IllegalArgumentException("Название полки не может быть пустым!");
        }
    }
}
