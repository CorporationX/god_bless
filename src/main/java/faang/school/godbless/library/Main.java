package faang.school.godbless.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Book, String> BOOKS = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book4 = new Book("1984", "George Orwell", 1949);

        add(book1, "A");
        add(book2, "B");
        add(book3, "C");
        add(book4, "D");
        removeBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        System.out.println("\nFinding a book:");
        findBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        System.out.println();
        System.out.println(BOOKS);
    }

    public static void add(Book book, String location){
        BOOKS.put(book, location);
    }

    public static void removeBook(String title, String author, int year) {
        BOOKS.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year){
        BOOKS.get(new Book(title, author, year));
        System.out.println("Book found. Location: " + BOOKS);
    }
}

