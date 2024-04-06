package faang.school.godbless.BJS2_4273;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {

        addBook(new Book("Harry Potter", "J.K. Rowling", 1997), "Magic-shelf");
        addBook(new Book("Angels and Demons", "Brown", 2000), "Best-seller shelf");
        addBook(new Book("The Alchemist", "C. Paulo", 2015), "Popular-shelf");

        removeBook("Angels and Demons", "Brown", 2000);

        findBook("The Alchemist", "C. Paulo", 2015);

        outputInfoAllBooks();
    }

    private static void addBook(Book book, String path) {
        books.put(book, path);
    }

    private static void removeBook(String bookName, String bookAuthor, int bookYear) {
        books.remove(new Book(bookName, bookAuthor, bookYear));
    }

    private static void findBook(String bookName, String bookAuthor, int bookYear) {
        System.out.println(books.get(new Book(bookName, bookAuthor, bookYear)));
    }

    private static void outputInfoAllBooks() {
        books.forEach((book, shelf) -> System.out.println(book.toString() + " : " + shelf));
    }
}
