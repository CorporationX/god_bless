package school.faang.sprint1.task_45352;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@AllArgsConstructor
public class LibrarySystem {

    private Map<Book, String> bookLocation;

    public Book addBook(String title, String author, int year, String location) {
        validateParameters(title, author, location);
        Book bookToAdd = new Book(title, author, year);

        if (bookLocation.containsKey(bookToAdd)) {
            String oldLocation = bookLocation.put(bookToAdd, location);
            System.out.println("The book " + bookToAdd + " has been moved from " + oldLocation + " to " + location);
        } else {
            bookLocation.put(bookToAdd, location);
            System.out.println("The book " + bookToAdd + " has been placed at " + location);
        }

        return bookToAdd;
    }

    public void removeBook(String title, String author, int year) {
        validateParameters(title, author);
        Book bookToRemove = new Book(title, author, year);

        String oldLocation = bookLocation.remove(bookToRemove);
        if (oldLocation != null) {
            System.out.println("The book " + bookToRemove + " has been removed from " + oldLocation);
        } else {
            System.out.println("The book " + bookToRemove + " was never added to the system");
        }
    }

    public String findBook(String title, String author, int year) {
        validateParameters(title, author);
        Book bookToSearch = new Book(title, author, year);

        if (!bookLocation.containsKey(bookToSearch)) {
            throw new NoSuchElementException("The book requested " + bookToSearch + " has not been found!");
        }
        String location = bookLocation.get(bookToSearch);
        System.out.println("The book " + bookToSearch + " is located at " + location);
        return location;
    }

    public void printAllBooks() {
        bookLocation.forEach((key, value) -> System.out.println("The book " + key + " is located at " + value));
    }

    private void validateParameters(String... parameters) {
        Arrays.stream(parameters).filter(Objects::isNull).findAny().ifPresent(p -> {
            throw new IllegalArgumentException("One or more arguments are null");
        });
        Arrays.stream(parameters).filter(String::isBlank).findAny().ifPresent(p -> {
            throw new IllegalArgumentException("One or more arguments are empty or blank strings");
        });
    }
}
