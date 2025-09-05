package school.faang.library_vesterossa;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {

    static Map<Book, String> bookStand = new HashMap<>();

    static void addBook(String title, String author, int year, String location) {
        bookStand.put(new Book(title, author, year), location);
        System.out.println("\n[+] Добавлена новая книга: " +
                "\n\tНазвание: " + title +
                "\n\tАвтор: " + author +
                "\n\tГод издания: " + year +
                "\n\tПолка: №" + location);
    }

    static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookStand.get(book);
        if (location != null) {
            bookStand.remove(book);
            System.out.println("\n[X] Удалена книга: " +
                    "\n\tНазвание: " + title +
                    "\n\tАвтор: " + author +
                    "\n\tГод издания: " + year +
                    "\n\tПолка: №" + location);
        } else {
            System.out.println("[!] Книга не найдена!");
        }
    }

    static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = bookStand.get(book);
        if (bookStand.containsKey(book)) {
            System.out.println("\n[*] Книга найдена: " +
                    "\n\tНазвание: " + title +
                    "\n\tАвтор: " + author +
                    "\n\tГод издания: " + year +
                    "\n\tПолка: №" + location);
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
            System.out.println("\n[*] Книга: " +
                    "\n\tНазвание: " + book.getTitle() +
                    "\n\tАвтор: " + book.getAuthor() +
                    "\n\tГод издания: " + book.getYear() +
                    "\n\tПолка: №" + bookWithPlace.getValue());
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
