package school.faang.sprint1.bjs_45304;

import java.util.HashMap;

public class LibrarySystem {
    private final HashMap<Book, String> books = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book newBook = new Book(title, author, year);
        if (!books.containsKey(newBook)) {
            books.put(newBook, location);
        }
    }

    public void removeBook(String title, String author, int year) {
        Book bookForRemove = new Book(title, author, year);
        if (books.containsKey(bookForRemove)) {
            books.remove(bookForRemove);
            System.out.println("This book has been removed");
        } else {
            System.out.println("Book not found");
        }
    }

    public void findBook(String title, String author, int year) {
        Book searchBook = new Book(title, author, year);
        if (!books.containsKey(searchBook)) {
            System.out.println("Book not found");
        } else {
            System.out.println("Book is located on " + books.get(searchBook));
        }
    }

    public void printAllBooks() {
        books.forEach((book, location) ->
                System.out.println(book + " -> " + location));
    }
}
