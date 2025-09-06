package school.faang.library_vesterossa;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    private static final Map<Book, String> bookStand = new HashMap<>();

    static void addBook(String title, String author, int year, String location) {
        bookStand.put(new Book(title, author, year), location);
        System.out.printf("""
                
                [+] Добавлена новая книга:\s
                \tНазвание: %s
                \tАвтор: %s
                \tГод издания: %d
                \tПолка: №%s
                """, title, author, year, location);
    }

    static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookStand.remove(book);
        if (location != null) {
            System.out.printf("""
                    
                    [X] Удалена книга:\s
                    \tНазвание: %s
                    \tАвтор: %s
                    \tГод издания: %d
                    \tПолка: №%s
                    """, title, author, year, location);
        } else {
            System.out.println("[!] Книга не найдена!");
        }
    }

    static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookStand.get(book);
        if (location != null) {
            System.out.printf("""
                    
                    [*] Книга найдена:\s
                    \tНазвание: %s
                    \tАвтор: %s
                    \tГод издания: %d
                    \tПолка: №%s
                    """, title, author, year, location);
        } else {
            System.out.println("\n[!] Книга не найдена!");
        }
    }

    static void printAllBooks() {
        if (bookStand.isEmpty()) {
            System.out.println("\n[!] В библиотеке нет книг!");
            return;
        }

        System.out.println("\n[*] Всего книг в библиотеке: " + bookStand.size());
        for (Map.Entry<Book, String> bookWithPlace : bookStand.entrySet()) {
            Book book = bookWithPlace.getKey();
            System.out.printf("""
                    
                    [*] Книга:\s
                    \tНазвание: %s
                    \tАвтор: %s
                    \tГод издания: %d
                    \tПолка: №%s
                    """, book.getTitle(), book.getAuthor(), book.getYear(), bookWithPlace.getValue());
        }
    }

    public static void main(String[] args) {

        System.out.println("\n=== Добавление книг ===");
        addBook("Fairy tale 1", "Ladro", 1900, "1");
        addBook("Fairy tale 2", "Ladro", 1911, "1");
        addBook("Rock: part 1", "Paul", 1910, "1");
        addBook("Rock: part 2", "Paul", 1920, "2");
        addBook("Fairy tale 3", "Ladro", 1922, "2");

        System.out.println("\n\n=== Вывод всех книг ===");
        printAllBooks();

        System.out.println("\n\n=== Удаление книг ===");
        removeBook("Fairy tale 2", "Ladro", 1911);
        removeBook("Fairy tale 3", "Ladro", 1922);
        removeBook("Rock: part 2", "Paul", 1920);

        System.out.println("\n\n=== Поиск книг ===");
        findBook("Fairy tale 1", "Ladro", 1900);
        findBook("Rock: part 2", "Paul", 1920);
        findBook("Rock: part 1", "Paul", 1910);

        System.out.println("\n\n=== Вывод всех книг ===");
        printAllBooks();

        System.out.println("\n\n=== Удаление книг ===");
        removeBook("Fairy tale 1", "Ladro", 1900);
        removeBook("Rock: part 1", "Paul", 1910);

        System.out.println("\n\n=== Вывод всех книг ===");
        printAllBooks();
    }
}
