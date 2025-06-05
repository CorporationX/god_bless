package school.faang.the_library_of_westeros_bjs2_79622;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class LibrarySystem {
    private final HashMap<Book, String> library = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(LibrarySystem.class);

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        library.put(book, location);
        System.out.printf("Книга %s добавлена\n", title);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);
        Object removed = library.remove(bookToRemove);

        if (removed == null) {
            logger.warn("Книга не найдена в библиотеке\n");
            System.out.printf("Книга %s не найдена\n", title);
        } else {
            logger.info("Книга успешно удалена\n");
            System.out.printf("Книга %s удалена\n", title);
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        if (library.get(bookToFind) == null) {
            System.out.println("Книга не найдена\n");
        } else {
            System.out.println(library.get(bookToFind));
        }
    }

    public void printAllBooks() {
        Set<Map.Entry<Book, String>> entries = library.entrySet();

        for (Map.Entry<Book, String> entry : entries) {
            Book key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%s %s\n", key.toString(), value);
        }
    }
}
