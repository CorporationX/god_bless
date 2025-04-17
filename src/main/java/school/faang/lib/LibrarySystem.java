package school.faang.lib;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (title == null || title.isEmpty()) {
            System.out.printf("Неверно указано название.");
            return;
        }
        if (author == null || author.isEmpty()) {
            System.out.printf("Неверно указан автор.");
            return;
        }
        if (location == null || location.isEmpty()) {
            System.out.printf("Неверно указано местоположение.");
            return;
        }

        books.put(new Book(title, author, year), location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return books.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (books.containsKey(book)) {
            return "Книга найдена. Местонахождение: %s".formatted(books.get(book));
        } else {
            return "Книга не найдена в библиотеке.";
        }
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.printf("Библиотека пуста.");
        } else {
            for (Map.Entry<Book, String> entry : books.entrySet()) {
                System.out.printf("%s находится на полке:  %s", entry.getKey(), entry.getValue());
            }
        }
    }
}
