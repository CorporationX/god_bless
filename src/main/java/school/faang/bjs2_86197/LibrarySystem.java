package school.faang.bjs2_86197;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> bookStringMap = new HashMap<>();

    void addBook(String title, String author, int year, String location) {
        bookStringMap.put(new Book(title, author, year), location);
    }

    void removeBook(String title, String author, int year) {
        bookStringMap.remove(new Book(title, author, year));
    }

    void findBook(String title, String author, int year) {
        String location = bookStringMap.get(new Book(title, author, year));
        if (location == null) {
            System.out.println("Книга не найдена");
        } else {
            System.out.println("Книга находится в " + location);
        }
    }

    void printAllBooks() {
        if (bookStringMap.isEmpty()) {
            System.out.println("Библиотека пуста");
        }

        for (Map.Entry<Book, String> entry : bookStringMap.entrySet()) {
            Book key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " → " + value);
        }
    }
}
