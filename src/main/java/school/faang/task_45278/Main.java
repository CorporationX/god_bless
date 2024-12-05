package school.faang.task_45278;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final HashMap<Book, String> library;

    public Main() {
        library = new HashMap<>();
    }

    public static void main(String[] args) {
        Main main = new Main();

        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("We", "Evgeniy Zamyatin", 1921);
        Book book3 = new Book("Atlas Shrugged", "Ayn Rand", 1957);

        main.addBook(book1, "Shelf 1");
        main.addBook(book2, "Shelf 2");
        main.addBook(book3, "Shelf 3");

        System.out.println(main.findBook("We", "Evgeniy Zamyatin", 1921));

        main.removeBook("Atlas Shrugged", "Ayn Rand", 1957);

        main.displayAllBooks();
    }

    public void addBook(Book book, String location) {
        library.put(book, location);
        System.out.println("Book added: " + book + " at " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        if (library.remove(bookToRemove) != null) {
            System.out.println("Book removed: " + bookToRemove);
        } else {
            System.out.println("Book not found: " + bookToRemove);
        }
    }

    public String findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        if (library.containsKey(bookToFind)) {
            return "Book found: " + bookToFind + " at " + library.get(bookToFind);
        } else {
            return "Book not found: " + bookToFind;
        }
    }

    public void displayAllBooks() {
        if (library.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Map.Entry<Book, String> entry : library.entrySet()) {
                System.out.println(entry.getKey() + " - Location: " + entry.getValue());
            }
        }
    }
}