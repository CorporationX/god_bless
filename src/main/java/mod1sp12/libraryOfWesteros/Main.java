package mod1sp12.libraryOfWesteros;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    @Getter
    private static Map<Book, String> library = new HashMap<>(
            Map.of(new Book("Harry Potter", "J.K. Rowling", 1997), "number of shelf: 1",
                    new Book("Lord of the Rings", "J.R. Talking", 1993), "number of shelf: 2",
                    new Book("Game of Thrones", "J. Martin", 1994), "number of shelf: 3")
    );

    @Getter
    private static int bookNumber = 3;

    public static void addBookToLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.put(book, ("number of shelf: " + (++bookNumber)));
    }

    public static void removeBookFromLibrary(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static String getShelfInLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.get(book);
    }

    public static void printAllBooksInLibrary() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printAllBooksInLibrary();
    }
}
