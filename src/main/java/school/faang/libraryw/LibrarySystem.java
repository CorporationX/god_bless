package school.faang.libraryw;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> LOCATION_BOOK = new HashMap<Book, String>();

    public void addBook(String title, String author, int year, String location) {
        isNullArguments(title, author, year);
        if (location == null || location.isEmpty()) {
            throw new NullPointerException("Местоположение книги не может быть пустым.");
        }
        LOCATION_BOOK.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        isNullArguments(title, author, year);
        LOCATION_BOOK.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        isNullArguments(title, author, year);
        var key = new Book(title, author, year);
        if (LOCATION_BOOK.containsKey(key)) {
            System.out.println(LOCATION_BOOK.get(key));
        } else {
            System.out.println("Данной книги нет в библиотеке");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : LOCATION_BOOK.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void isNullArguments(String title, String author, int year) {
        if (title == null || title.isEmpty()) {
            throw new NullPointerException("Название не может быть пустым");
        }
        if (author == null || author.isEmpty()) {
            throw new NullPointerException("Имя автора не может быть пустым");
        }
        if (year <= 0) {
            throw new NullPointerException("Год должен быть больше 0");
        }
    }
}
