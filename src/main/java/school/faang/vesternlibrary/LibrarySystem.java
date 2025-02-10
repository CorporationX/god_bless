package school.faang.vesternlibrary;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> bookPlace = new HashMap<>();

    public boolean addBook(String title, String author, int year, String location) {
        validationTitle(title);
        validationAuthor(author);
        validationYear(year);
        validationLocation(location);
        Book newBook = new Book(title, author, year);
        if (bookPlace.containsKey(newBook)) {
            System.out.println("Book already exists");
            return false;
        }
        bookPlace.put(newBook, location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        validationTitle(title);
        validationAuthor(author);
        validationYear(year);
        Book newBook = new Book(title, author, year);
        if (!bookPlace.containsKey(newBook)) {
            System.out.println("Book does not exist");
            return false;
        }

        bookPlace.remove(newBook);
        return true;
    }

    public boolean findBook(String title, String author, int year) {
        validationTitle(title);
        validationAuthor(author);
        validationYear(year);
        Book newBook = new Book(title, author, year);
        if (!bookPlace.containsKey(newBook)) {
            System.out.println("Book is not found");
            return false;
        }
        System.out.println(MessageFormat.format("Book {0} is found, it location is {1} ",
                newBook.getTitle(), bookPlace.get(newBook)));
        return true;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookPlace.entrySet()) {
            System.out.println(MessageFormat.format("Book {0} is found, it location is {1} ",
                    entry.getKey().getTitle(), entry.getValue()));
        }
    }

    private void validationTitle(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
    }

    private void validationAuthor(String author) {
        if (author.isBlank()) {
            throw new IllegalArgumentException("Author is required");
        }
    }

    private void validationLocation(String location) {
        if (location.isBlank()) {
            throw new IllegalArgumentException("Location is required");
        }
    }

    private void validationYear(int year) {
        int minYear = 0;
        int maxYear = 2025;
        if (year < minYear || year > maxYear) {
            throw new IllegalArgumentException("Year is required");
        }
    }


}
