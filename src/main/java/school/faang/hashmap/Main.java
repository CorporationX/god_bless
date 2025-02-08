package school.faang.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", 1997, "Shelf 1");
        librarySystem.addBook("1984", "George Orwell", 1949, "Shelf 2");
        librarySystem.addBook("The Master and Margarita", "Mikhail Bulgakov", 1967, "Shelf 3");

        librarySystem.printAllBooks();

        librarySystem.findBook("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", 1997);

        librarySystem.removeBook("1984", "George Orwell", 1949);

        librarySystem.printAllBooks();
    }
}

class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}

class LibrarySystem {
    private Map<Book, String> library;

    public LibrarySystem() {
        this.library = new HashMap<>();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Book removed: " + book);
        } else {
            System.out.println("Book not found");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Book found at location: " + library.get(book));
        } else {
            System.out.println("Book not found");
        }
    }

    public void printAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " location: " + entry.getValue());
            }
        }
    }
}
