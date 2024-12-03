package school.faang.task_45253;

import java.util.*;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();
    private final Set<String> shelfs = new HashSet<>(
            Set.of(
                    "A", "B", "C", "D", "E", "F"
            )
    );

    public boolean addBook(String title, String author, int year, String location) {
        Book request = new Book(title, author, year);
        if (library.containsKey(request) || !shelfs.contains(location)) {
            return false;
        }
        library.put(request, location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        Book request = new Book(title, author, year);
        if (library.containsKey(request)) {
            library.remove(request);
            return true;
        }
        return false;
    }

    public String findBook(String title, String author, int year) {
        Book request = new Book(title, author, year);
        if (library.containsKey(request)) {
            return "The book located in shelf of : " + library.get(request);
        }
        return "Book was not found";
    }

    public void printAllBooks() {
        for(Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
