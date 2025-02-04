package school.faang.BJS2_56922;

import java.util.HashMap;
import java.util.Map;

public class LibarySystem {
    private Map<Book, String> locationOfTheBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Location не может быть пустым");
        }
        if (locationOfTheBook.get(book) != null)  {
            System.out.println("Такая книга уже есть в библиотеке");
        } else {
            locationOfTheBook.put(book, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (locationOfTheBook.isEmpty()) {
            System.out.println("В библиотеке нет книг");
        }
        if (locationOfTheBook.get(book) == null) {
            System.out.println("Такой книги нет");
        } else {
            locationOfTheBook.remove(book);
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String result = locationOfTheBook.get(book);
        if (!locationOfTheBook.containsKey(book)) {
            System.out.println("Такой книги нет: "  + book);
        } else {
            System.out.println("Расположение книги: " + locationOfTheBook.get(book));
        }
    }

    public void printAllBooks() {
        for (Map.Entry book : locationOfTheBook.entrySet()) {
            System.out.println("Книга: " + book.getKey() + "Расположение: " + book.getValue());
        }
    }
}
