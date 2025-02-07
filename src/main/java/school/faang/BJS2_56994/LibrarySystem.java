package school.faang.BJS2_56994;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class LibrarySystem {
    private static final Map<Book, String> bookShelfMap = new ConcurrentHashMap<>();

    private static Map<Book, String> getBookShelfMap() {
        return bookShelfMap;
    }

    public static void addBook(String title, String author, int year, String location) {
        if (title == null || title.trim().isEmpty()
                || author == null || author.trim().isEmpty()
                || location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Параметры title, author и location не могут быть null или пустыми строками."
            );
        }

        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException("Год должен быть четырёхзначным числом.");
        }

        Book newBook = new Book(title, author, year);
        bookShelfMap.put(newBook, location);
    }

    public static void removeBook(String title, String author, int year) {
        bookShelfMap.entrySet().removeIf(entry ->
                entry.getKey().getTitle().equals(title)
                        && entry.getKey().getAuthor().equals(author)
                        && entry.getKey().getYear() == year
        );
    }

    public static void findBook(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : getBookShelfMap().entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getYear() == year) {
                System.out.println("Местоположение книги: " + entry.getValue());
                return;
            }
        }
        System.out.println("Книга с такими параметрами не найдена.");
    }

    public static void printAllBooks() {
        if (getBookShelfMap().isEmpty()) {
            System.out.println("📚 Библиотека пуста! Нет доступных книг.");
            return;
        }

        System.out.println("📚 Список всех книг в библиотеке:");
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("| %-35s | %-20s | %-6s | %-10s |\n",
                "Название", "Автор", "Год", "Полка");
        System.out.println("------------------------------------------------------------------------------");

        getBookShelfMap().forEach((book, location) ->
                System.out.printf("| %-35s | %-20s | %-6d | %-10s |\n",
                        book.getTitle(), book.getAuthor(), book.getYear(), location)
        );

        System.out.println("-----------------------------------------------------------");
    }
}
