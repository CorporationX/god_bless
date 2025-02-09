package school.faang.library_westerossa;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        libraryMap.putIfAbsent(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        libraryMap.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            System.out.println("Книга " + title + " находится: " + libraryMap.get(book));
            return;
        }
        System.out.println("Книги " + title + " нет в библиотеке Вестеросса");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
