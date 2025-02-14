package school.faang.vesterosslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> BOOK_MAP = new HashMap<>();

    private static final Book first = new Book("Anna Karenina", "Tolstoy", 1873);
    private static final Book second = new Book("Master and Margorita", "Bulgakov", 1940);
    private static final Book thirt = new Book("Idiot", "Dostoevsky", 1869);

    public static void main(String[] args) {

        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Anna Karenina", "Tolstoy", 1873, "1");
        librarySystem.addBook("Master and Margorita", "Bulgakov", 1940, "2");
        librarySystem.addBook("Idiot", "Dostoevsky", 1869, "3");

        librarySystem.removeBook("Master and Margorita", "Bulgakov", 1940);

        String location = librarySystem.findBook("Idiot", "Dostoevsky", 1869);
        System.out.println("Найдена книга на полке " + location);

        librarySystem.printAllBooks();
    }

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        BOOK_MAP.put(book, location);
        System.out.println("Книга добавлена: " + book + " на полку: " + location);
    }

    public boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return BOOK_MAP.remove(book) != null;
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : BOOK_MAP.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }

    public String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return BOOK_MAP.getOrDefault(book, "Книга не найдена в библиотеке.");
    }
}