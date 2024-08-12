package faang.school.godbless.bjs219520;

import java.util.Map;

public class BookManager {
    public static void addBook(Map<Book, String> books, String title, String author, int year, String shelf) {
        Book newBook = new Book(title, author, year);
        books.put(newBook, shelf);
        System.out.println("Book added on shelf " + shelf);
    }

    public static void deleteBook(Map<Book, String> books, String title, String author, int year) {
        if (!books.containsKey(new Book(title, author, year))) {
            System.out.println("Book not found");
        } else {
            books.remove(new Book(title, author, year));
            System.out.println("Book deleted");
        }
    }

    public static void findBook(Map<Book, String> books, String title, String author, int year) {
        if (!books.containsKey(new Book(title, author, year))) {
            System.out.println("Book not found");
        } else {
            String shelf = books.get(new Book(title, author, year));
            System.out.println("Book " + title + " is on shelf " + shelf);
        }
    }

    public static void findAll(Map<Book, String> books) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            Book book = entry.getKey();
            String shelf = entry.getValue();
            System.out.println("Book: " + book + ", Location: " + shelf);
        }
    }
}
