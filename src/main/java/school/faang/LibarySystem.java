package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LibarySystem {
    private Map<Book, String> locationOfTheBook = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (location !=null || location.isEmpty()  || locationOfTheBook.get(book) == null) {
            locationOfTheBook.put(book, location);
        }
        else {
        throw new IllegalArgumentException("Местоположение не может быть пустым");
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (locationOfTheBook.isEmpty() || locationOfTheBook.get(book) != null) {
            locationOfTheBook.remove(book);
        } else {
            System.out.println(" Такой книги нет или в библиотеке нет книг");
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
