package school.faang.task_45241;

import lombok.Getter;

import java.util.Map;

@Getter
public class LibrarySystem {
    private final Map<Book, String> library;

    public LibrarySystem(Map<Book, String> library) {
        this.library = library;
    }

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public String findBook(String title, String author, int year) {
        return library.get(new Book(title, author, year));
    }

    public void printAllBooks() {
        for (var book : library.entrySet()) {
            System.out.println(book.getKey() + " " + book.getValue());
        }
    }
}
