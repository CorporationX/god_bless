package school.faang.task_43520;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location == null) {
            System.out.println(book + " не найдена");
        } else {
            System.out.println(book + " на полке " + location);
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : library.entrySet()) {
            System.out.println(book.getKey() + " на полке " + book.getValue());
        }
    }
}
