package school.faang.sprint1.bjs_45304;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LibrarySystem {
    private HashMap<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookForRemove = new Book(title, author, year);
        if (books.containsKey(bookForRemove)) {
            books.remove(bookForRemove);
            System.out.println("This book has been removed");
        } else {
            System.out.println("Book not found");
        }
    }

    public void findBook(String title, String author, int year) {
        Book searchBook = new Book(title, author, year);
        if (!books.containsKey(searchBook)) {
            System.out.println("Book not found");
        } else {
            Iterator<Map.Entry<Book, String>> iterator = books.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Book, String> pair = iterator.next();
                if (searchBook.equals(pair.getKey())) {
                    System.out.println("Book is located on " + pair.getValue());
                    break;
                }
            }
        }
    }

    public void printAllBooks() {
        books.forEach((book, location) ->
                System.out.println(book + " -> " + location));
    }
}
