package school.faang.vesterosslibrary;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LibrarySystem {
    private final Map<Book, String> bookMap = new HashMap<>();

    private static final Book BOOK1 = new Book("Anna Karenina", "Tolstoy", 1873);
    private static final Book BOOK2 = new Book("Master and Margorita", "Bulgakov", 1940);
    private static final Book BOOK3 = new Book("Idiot", "Dostoevsky", 1869);

    private static final Logger log = Logger.getLogger(LibrarySystem.class.getName());

    public LibrarySystem() {
        bookMap.put(BOOK1, "Classic Russian literature");
        bookMap.put(BOOK2, "Magical realism masterpiece");
        bookMap.put(BOOK3, "Psychological novel");
    }

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Anna Karenina", "Tolstoy", 1873, "1");
        librarySystem.addBook("Master and Margorita", "Bulgakov", 1940, "2");
        librarySystem.addBook("Idiot", "Dostoevsky", 1869, "3");

        librarySystem.removeBook("Master and Margorita", "Bulgakov", 1940);

        String location = librarySystem.findBook("Idiot", "Dostoevsky", 1869);
        log.info("Найдена книга на полке " + location);

        librarySystem.printAllBooks();
    }

    public void addBook(String title, String author, int year, String location) {
        if (author == null && !author.isEmpty()) {
            log.warning("Поле не может быть пустым");
            return;
        }

        if (year <= 0) {
            log.warning("Год публикации должен быть больше нуля");
            return;
        }

        Book book = new Book(title, author, year);
        bookMap.put(book, location);
        log.info("Книга добавлена: " + book + " на полку: " + location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        boolean removed = bookMap.remove(book) != null;
        if (removed) {
            log.info("Книга удалена: " + book);
        } else {
            log.warning("Книга не найдена для удаления: " + book);
        }
        return removed;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
            log.info(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return bookMap.getOrDefault(book, "Книга не найдена в библиотеке.");
    }
}