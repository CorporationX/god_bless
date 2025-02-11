package school.faang;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    Map<Book, String> map = new HashMap<>();


    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        map.put(book, location);
        System.out.println("Book is add: " + book + " location: " + location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return map.remove(book) != null;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = map.get(book);
        if (location != null) {
            System.out.println("Book find" + " " + title + " " + "location"  + " " + location);
            return location;
        } else {
            System.out.println("Book not fiend");
            return null;
        }
    }

    public void printAllBooks() {
        if (map.isEmpty()) {
            System.out.println("library is empty");
        } else {
            for (Map.Entry<Book, String> entry : map.entrySet()) {
                Book book = entry.getKey();
                String location = entry.getValue();
                System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getYear() + ", Location: " + location);
            }
        }
    }
}





