package faang.school.godbless.vesteros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Book almanac = new Book("Medecine almanac", "Robert Grey", 1995);
        Book history = new Book("History of Vesteros", "Alan Rickhman", 1923);
        Book romantic = new Book("Traveling with Maria", "Julian Royling", 2003);
        BOOKS.put(almanac, "23");
        BOOKS.put(history, "1");
        BOOKS.put(romantic, "7");

        addBook(new Book("Horse fighting", "Unknown", 1785), "2");
        showAllBooks();
        removeBook("History of Vesteros", "Alan Rickhman", 1923);
        findBook("Medecine almanac", "Robert Grey", 1995);
    }

    public static void addBook(Book book, String section) {
        BOOKS.put(book, section);
    }

    public static void removeBook(String title, String author, int year) {
        BOOKS.remove(findBookByAllFields(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        System.out.println(BOOKS.get(findBookByAllFields(title, author, year)));
    }

    public static void showAllBooks() {
        BOOKS.forEach((book, section) -> System.out.println(book + " section: " + section));
    }

    private static Book findBookByAllFields(String title, String author, int year) {
        Book book = BOOKS.keySet().stream().filter(b ->
                b.getTitle().equals(title) && b.getAuthor().equals(author) && b.getYear() == year).findFirst().orElse(null);
        if (book == null) {
            throw new IllegalArgumentException(String.format("Book with tittle: %s , author: %s , year: %d is not found",
                    title, author, year));
        }
        return book;
    }
}
