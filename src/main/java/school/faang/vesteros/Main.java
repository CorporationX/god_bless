package school.faang.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997);
        Book book2 = new Book("Lord of the Rings", "J.R.R. Tolkien", 1954);

        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);

        Map<Book, String> bookAndShelf = new HashMap<>();

        addBock(bookAndShelf, book, "A");
        addBock(bookAndShelf, book1, "B");
        addBock(bookAndShelf, book2, "C");
        addBock(bookAndShelf, book3, "D");

//        removeBook(bookAndShelf, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
//        findBook(bookAndShelf, "The Hobbit", "J.R.R. Tolkien", 1937);

        for (Map.Entry<Book, String> entry : bookAndShelf.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void addBock (Map<Book, String> map, Book book, String shelf) {
        map.put(book, shelf);
    }

    public static void removeBook (Map<Book, String> map, String name, String author, int year) {
        Book book = new Book(name, author, year);
        map.remove(book);
    }

    public static void findBook (Map<Book, String> map, String name, String author, int year){
        map.forEach((book, shelf) -> {
                    if (book.getTitle().equals(name) && book.getAuthor().equals(author) && book.getYear() == year) {
                        System.out.println("Search result - " + book + " - " + shelf);
                    }
                });
    }
}
