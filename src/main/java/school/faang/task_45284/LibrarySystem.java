package school.faang.task_45284;

import school.faang.task_45284.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    Map<Book, String> books = new HashMap<Book, String>();

    public boolean addBook(String title, String author, int year, String location) {

        if (!(title == null) && !(author == null) && !(location == null)) {
            Book bookToAdd = new Book(title, author, year);
            books.put(bookToAdd, location);
        } else {
            throw new IllegalArgumentException("Title and author cannot be null");
        }
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        if ((title == null) && (author == null)) {
            throw new IllegalArgumentException("Title and author cannot be null");
        }
        Book booksForRemove = new Book(title, author, year);
        if (books.remove(booksForRemove) != null) {
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found in the map");
        }
        return true;
    }

    public Book findBook(String title, String author, int year) {
        if (title == null || author == null) {
            throw new IllegalArgumentException("Title and author cannot be null");
        }
        Book bookForFind = new Book(title, author, year);
        if (books.containsKey(bookForFind)) {
            return bookForFind;
        }
        return null;
    }

    public void printAllBooks() {
        System.out.println("Library Catalog");
        System.out.println("=".repeat(50));
        System.out.println("Total books: " + books.size());
        System.out.println();

        books.forEach((book, value) -> {
            if (book == null || value == null) {
                System.out.println("Invalid entry in books map");
                return;
            }
            System.out.println("Title       : " + book.getTitle());
            System.out.println("Author      : " + book.getAuthor());
            System.out.println("Year        : " + book.getYear());
            System.out.println("Description : " + value);
            System.out.println("-".repeat(50));
        });
    }


}
