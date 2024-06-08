package faang.school.godbless.BJS2_8230;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookShelves = new HashMap<>();

        Book book_1 = new Book("Magic java", "Ivanov", 1991);
        Book book_2 = new Book("Great java", "Petrov", 1992);
        Book book_3 = new Book("Ultra java", "Sidorov", 1993);
        Book book_4 = new Book("Mega java", "Palkin", 1994);

        bookShelves.put(book_1, "shelve A");
        bookShelves.put(book_2, "shelve B");
        bookShelves.put(book_3, "shelve C");

        allBooksAndShelvesListing(bookShelves);

        addBookOnShelves(bookShelves, book_4, "shelve D");

        allBooksAndShelvesListing(bookShelves);

        deleteBookFromShelves(bookShelves, "Great java", "Petrov", 1992);

        allBooksAndShelvesListing(bookShelves);

        searchBookAndListingShelve(bookShelves, "Mega java", "Palkin", 1994);

    }

    public static void addBookOnShelves(Map<Book, String> bookShelves, Book book, String shelve) {
        if (bookShelves != null && book != null && shelve != null) {
            bookShelves.put(book, shelve);
        }
    }

    public static void deleteBookFromShelves(Map<Book, String> bookShelves, String title, String author, int year) {
        if (title != null && author != null && bookShelves != null) {
            Book book = new Book(title, author, year);
            bookShelves.remove(book);
        }
    }

    public static void searchBookAndListingShelve(Map<Book, String> bookShelves, String title, String author, int year) {
        if (bookShelves != null && title != null && author != null) {
            Book book = new Book(title, author, year);
            String shelve = bookShelves.get(book);
            System.out.println("Книга " + book + " находится на полке " + shelve);
        }
    }

    public static void allBooksAndShelvesListing(Map<Book, String> bookShelves) {
        if (bookShelves != null) {
            for (Map.Entry<Book, String> entry : bookShelves.entrySet()) {
                System.out.println("Книга " + entry.getKey() + " находится на полке " + entry.getValue());
            }
        }
    }
}
