package school.faang.bjs2_79677;

import lombok.Getter;
import lombok.Setter;
import school.faang.util.ParameterUtil;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        this.library = new HashMap<>();
    }

    public LibrarySystem(Map<Book, String> library) {
        if (library == null) {
            throw new IllegalArgumentException("books map is null");
        }
        this.library = library;
    }

    public void addBook(String title, String author, int year, String location) {
        ParameterUtil.checkStringArg(title, "title");
        ParameterUtil.checkStringArg(author, "author");
        ParameterUtil.checkStringArg(location, "location");

        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.printf("This book is already in the library, located at %s\n", library.get(book));
            return;
        }

        library.put(book, location);
        System.out.printf("the book: %s has been added to %s\n", book, location);
    }

    public void removeBook(String title, String author, int year) {
        ParameterUtil.checkStringArg(title, "title");
        ParameterUtil.checkStringArg(author, "author");

        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            System.out.printf("the book: %s not found\n", book);
            return;
        }

        library.remove(book);
        System.out.printf("the book: %s has been removed from the library\n", book);
    }

    public void findBook(String title, String author, int year) {
        ParameterUtil.checkStringArg(title, "title");
        ParameterUtil.checkStringArg(author, "author");

        Book book = new Book(title, author, year);
        if (!library.containsKey(book)) {
            System.out.printf("the book: %s not found\n", book);
            return;
        }

        System.out.printf("the book: %s located at %s\n", book, library.get(book));
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("All books in library");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("%s located at %s\n", entry.getKey(), entry.getValue());
        }
    }
}
