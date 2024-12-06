package school.faang.task_45332;

import java.util.Iterator;
import java.util.Map;

public class LibrarySystem {
    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        Main.books.put(book, location);
        System.out.println("The Book: " + book + " added to the: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        Iterator<Map.Entry<Book, String>> iterator = Main.books.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(book)) {
                iterator.remove();
            }
        }
        System.out.println("The Book removed: " + book + " from the shelf: " + Main.books.get(book));
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (Main.books.containsKey(book)) {
            String location = Main.books.get(book);
            System.out.println("The Book: " + book + " found in the: " + location);
        } else {
            System.out.println("The Book not found");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : Main.books.entrySet()) {
            System.out.println("The Book: " + entry.getKey() + " lies on the: " + entry.getValue());
        }
    }
}
