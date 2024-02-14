package faang.school.godbless.westeros_library;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Some Title", "Some Author", 1232);
        Book book2 = new Book("Some Title 2", "Some Author 2", 1245);
        Book book3 = new Book("Some Title 3", "Some Author 2", 1247);
        Book book4 = new Book("Some Title 4", "Some Author 5", 1230);

        bookMap.put(book1, "Shelf 1");
        bookMap.put(book2, "Shelf 1");
        bookMap.put(book3, "Shelf 7");

        addBook(book4, "Shelf 2");
        System.out.println();
        getAllBooks();
        deleteBook(book1);
        System.out.println();
        getBookByTitle(book4);
        System.out.println();
        getAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        bookMap.put(book, shelf);
    }

    public static void deleteBook(Book book) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            Book b = entry.getKey();
            if (book.equals(b)) {
                bookMap.remove(book);
                break;
            }
        }
    }


    public static void getBookByTitle(Book book) {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            Book b = entry.getKey();
            if (book.equals(b)) {
                System.out.println("Book location: " + entry.getValue());
                break;
            }
        }
    }

    public static void getAllBooks() {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            Book book = entry.getKey();
            System.out.println("Book title: " + book.getTitle() + ", author: " +
                    book.getAuthor() + ", year: " + book.getYear() + ", location: " + entry.getValue());
        }
    }

}
