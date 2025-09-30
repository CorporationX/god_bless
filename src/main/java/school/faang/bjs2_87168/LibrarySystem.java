package school.faang.bjs2_87168;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        books.put(book, location);
    }

    public void removeBook(String title, String author, int year) {
        /*Book removeBook = null;
        for (Map.Entry<Book, String> item : books.entrySet()) {
            Book book = item.getKey();
            if (title.equals(book.title)
                    && author.equals(book.author)
                    && year == book.year) {
                removeBook = book;
            }
        }
        if (removeBook != null) {
            books.remove(removeBook);
        }*/
        // Понял как работает hashMap и исправил

        Book book = new Book(title, author, year);
        books.remove(book);
    }

    public void findBook(String title, String author, int year) {
        /*boolean found = false;
        for (Map.Entry<Book, String> book : books.entrySet()) {
            if (title.equals(book.getKey().title)
                    && author.equals(book.getKey().author)
                    && year == book.getKey().year) {
                System.out.println("variable: " + book.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("not book");
        }*/
        Book book = new Book(title, author, year);
        books.getOrDefault(book, "not book");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> book : books.entrySet()) {
            System.out.println(book.hashCode() + " " + book.getValue());
        }
    }
}
