package school.faang.sprint_1.task_bjs245369;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (library.putIfAbsent(book, location) == null) {
            System.out.println("Book " + title + " was putted into library");
        } else {
            System.out.println("Book " + title + " is already exists in the library");
        }
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.remove(book) != null) {
            System.out.println("Book " + title + " was deleted from library");
            return true;
        } else {
            System.out.println("There is no book " + title + " in the library");
            return false;
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, "There is no book in library");
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("There is no books in library");
        } else {
            library.entrySet().stream()
                    .map(entry -> String.format("%s location is %s", entry.getKey(), entry.getValue()))
                    .forEach(System.out::println);
        }
    }
}
