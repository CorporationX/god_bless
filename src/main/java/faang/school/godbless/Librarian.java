package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Librarian {
    private HashMap<Book, String> library;

    public void addBook(Book book, String location) {
        if (book == null || location == null) {
            return;
        }
        library.put(book, location);
    }

    public void removeBooksByTitle(String title) {
        if (title == null) {
            return;
        }
        library.entrySet().removeIf(entry -> entry.getKey().getTitle().equals(title));
    }

    public void removeBooksByAuthor(String author) {
        if (author == null) {
            return;
        }
        library.entrySet().removeIf(entry -> entry.getKey().getAuthor().equals(author));
    }

    public void removeBooksByYear(int year) {
        library.entrySet().removeIf(entry -> entry.getKey().getYear() == year);
    }

    public Map<Book, String> findBooksLocationByTitle(String title) {
        if (title == null) {
            return new HashMap<>();
        }
        return library.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getTitle().equals(title))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Book, String> findBooksLocationByAuthor(String author) {
        if (author == null) {
            return new HashMap<>();
        }
        return library.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getAuthor().equals(author))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Book, String> findBooksLocationByYear(int year) {
        return library.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getYear() == year)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void printAllBooks() {
        System.out.println("All books in library");

        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Book " + entry.getKey().getTitle() + " | Location: " + entry.getValue());
        }
    }
}
