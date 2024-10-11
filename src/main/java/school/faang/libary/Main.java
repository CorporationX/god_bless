package school.faang.libary;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("book1", "talant1", 2004);
        Book book2 = new Book("book2", "talant2", 2005);
        Book book3 = new Book("book3", "talant3", 2006);
        books.put(book1, "pervaja polka");
        books.put(book2, "vtoraja polka");
        books.put(book3, "tretja polka");
    }

    public static void addBook(Book book, String location) {
        books.put(book, location);
    }

    public static void removeBook(String name, String author, int year) {
        Book bookForRemoval = new Book(name, author, year);
        books.remove(bookForRemoval);
    }

    public static void findBook(String name, String author, int year) {
        Book bookForRemoval = new Book(name, author, year);
        System.out.println(books.get(bookForRemoval));
    }

    public static void getAllBooks() {
        String stringBuilder = "";
        for (Book book : books.keySet()) {
            stringBuilder = "Book:  " + book + "  Location:  " + books.get(book);
            System.out.println(stringBuilder);
        }
    }
}
