package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<Book, String> booksCollection = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(addBook("Book", "Author", 2000, "1"));
        System.out.println(addBook("Book2", "Author2", 2000, "2"));

        System.out.println(removeBook("Book2", "Author2", 2000));
        System.out.println(removeBook("Book3", "Author2", 2000));
        getAllBooks();

        System.out.println(getBook("Book", "Author", 2000));
    }


    public static String addBook(String title, String author, int year, String shelf) {
        Book book = new Book(title, author, year);
        booksCollection.put(book, shelf);
        return "Successfully added: " + book;
    }


    public static String removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if(!booksCollection.containsKey(book)) {
            return "Book not found in the collection.";
        } else {
            booksCollection.remove(book);
            return "Successfully removed: " + book;
        }
    }


    public static String getBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if(!booksCollection.containsKey(book)) {
            return "Book not found in the collection.";
        }else{
            String shelf = booksCollection.get(book);
            return "Found " + book + " on the shelf with number " + shelf;
        }
    }


    public static void getAllBooks() {
        for(Map.Entry<Book, String> entry : booksCollection.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
