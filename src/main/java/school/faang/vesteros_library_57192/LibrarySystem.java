package school.faang.vesteros_library_57192;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> bookPlace = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Информация о местоположении книги не должна быть пустой");
        }
        if (bookPlace.get(book) != null) {
            System.out.println("Данная книга (или ее копия) уже хранится в библиотеке на месте: "
                    + bookPlace.get(book));
        } else {
            bookPlace.put(book, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (bookPlace.isEmpty()) {
            System.out.println("В библиотеке нет книг");
        }
        if (bookPlace.get(book) == null) {
            System.out.println("Такая книга не обнаружена");
        } else {
            bookPlace.remove(book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (!bookPlace.containsKey(book)) {
            System.out.println("Указанной книги нет в библиотеке");
        } else {
            System.out.println("Местоположение книги: " + bookPlace.get(book));
        }
    }

    public void printAllBooks() {
        for (Map.Entry book : bookPlace.entrySet()) {
            System.out.println("Книга: " + book.getKey() + " Местоположение: " + book.getValue());
        }
    }
}
