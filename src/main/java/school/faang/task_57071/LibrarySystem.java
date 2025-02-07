package school.faang.task_57071;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class LibrarySystem {
    private Map<Book, String> library = new HashMap<Book, String>();

    public boolean addBook(String title, String author, Integer year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        return true;
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        library.remove(book);
        return true;
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.get(book);
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}


