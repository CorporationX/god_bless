package faang.school.godbless.vesterossLibrary;

import java.util.HashMap;
import java.util.Map;


public class Main {

    private static Map<Book, String> libraryMap = new HashMap<>();

    static {
        libraryMap.put(new Book("Harry Potter", "J. K. Rowling", 1997), "Magic section");
        libraryMap.put(new Book("1994", "George Orwell", 1949), "Dystopian section");
        libraryMap.put(new Book("The Hunger Games", "Suzanne Collins", 2008), "Dystopian section");
        libraryMap.put(new Book("The Richest Man in Babylon", "George S. Clason", 1926), "Finance section");
    }

    public static void main(String[] args) {
        System.out.println("Print all books");
        printAllBooks();
        System.out.println("-------------------");

        System.out.println("add new book (new Book)");
        addBook(new Book("new Book", "Iam", 2024), "New Section");
        System.out.println("-------------------");

        System.out.println("remove thr richest");
        deleteBook("The Richest Man in Babylon", "George S. Clason", 1926);
        System.out.println("-------------------");

        System.out.println("Find and print Harry Potter");
        findBookAndSection("Harry Potter", "J. K. Rowling", 1997);
        System.out.println("-------------------");

        System.out.println("print all books");
        printAllBooks();
    }

    public static void addBook(Book book, String section) {
        if (libraryMap.containsKey(book)) {
            throw new IllegalArgumentException("This " + book + " already in the library");
        }

        libraryMap.put(book, section);
    }

    public static void deleteBook(String title, String author, int year) {
        Book bookToDelete = new Book(title, author, year);
        if (!libraryMap.containsKey(bookToDelete)) {
            throw new IllegalArgumentException("this " + bookToDelete + " is not in the library");
        }

        libraryMap.remove(bookToDelete);
    }

    public static void findBookAndSection(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        if (!libraryMap.containsKey(bookToFind)) {
            throw new IllegalArgumentException("this " + bookToFind + " is not in the library");
        }

        System.out.println(bookToFind + " is in the " + libraryMap.get(bookToFind));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.println(entry.getKey() + " is in the " + entry.getValue());
        }
    }
}
