package faang.school.godbless.BJS2_8241;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        addBook(new Book("Anton's life", "Andrew", 1942), "Ceiling");
        addBook(new Book("1984", "George", 1911), "Ceiling");
        addBook(new Book("The wonderful doctor", "Anton", 1864), "Ceiling");

        printInfoAboutAllBooks();

        removeBookByAuthor("Andrew");
        removeBookByTitle("1984");
        removeBookByYear(1864);

        System.out.println();
        printInfoAboutAllBooks();
    }

    public static void addBook(Book book, String location) {
        books.put(book, location);
    }

    public static void removeBookByTitle(String title) {
        // договоримся что у каждой книги уникальное название
        for (var book: books.entrySet()) {
            if (book.getKey().getTitle().equals(title)) {
                books.remove(book.getKey());
                break;
            }
        }
    }

    public static void removeBookByAuthor(String author) {
        for (var book: books.entrySet()) {
            if (book.getKey().getAuthor().equals(author)) {
                books.remove(book.getKey());
                break;
            }
        }
    }

    public static void removeBookByYear(int year) {
        for (var book: books.entrySet()) {
            if (book.getKey().getYear() == year) {
                books.remove(book.getKey());
                break;
            }
        }
    }

    public static void printInfoAboutBook(Book book) {
        System.out.println("Title: " + book.getTitle() + "\nAuthor: "
                + book.getAuthor() +
                "\nyear: " + book.getYear());
    }

    public static void printInfoAboutAllBooks() {
        for (var book: books.entrySet()) {
            printInfoAboutBook(book.getKey());
            System.out.println("-".repeat(20));
        }
    }
}
