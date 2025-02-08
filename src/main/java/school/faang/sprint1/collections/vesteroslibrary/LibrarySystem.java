package school.faang.sprint1.collections.vesteroslibrary;

import school.faang.sprint1.collections.vesteroslibrary.exceptions.BookNotFoundException;
import school.faang.sprint1.collections.vesteroslibrary.exceptions.DuplicateBookException;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> libraryMap = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        if (!libraryMap.containsKey(book)) {
            libraryMap.put(book, location);
        } else {
            throw new DuplicateBookException("Such a book already exists in the library");
        }
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            libraryMap.remove(book);
        } else {
            throw new BookNotFoundException("The book was not found in the library");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            System.out.println("The book '" + book.getTitle() + "' is on the " + libraryMap.get(book));
        } else {
            throw new BookNotFoundException("The book was not found in the library");
        }
    }

    public void printAllBooks() {
        if (libraryMap.isEmpty()) {
            throw new BookNotFoundException("There are no books in the library");
        } else {
            System.out.println("---List of books in the library---");
            for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
                System.out.println("Book title: '" + entry.getKey().getTitle() + "', location: " + entry.getValue());
            }
            System.out.println("..........\n");
        }
    }
}
