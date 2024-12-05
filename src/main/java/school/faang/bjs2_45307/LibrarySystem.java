package school.faang.bjs2_45307;

import java.util.Map;

public class LibrarySystem {
    public static void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        Main.library.put(book, location);
        System.out.println("Книга добавлена: " + book + " на местонахождение: " + location);
    }

    public static boolean removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println("Книга удалена: " + book + " на местонахождение: ");
        return Main.library.remove(book) != null;
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return Main.library.getOrDefault(book, "Книга не найдена в библиотеке.");
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : Main.library.entrySet()) {
            System.out.println(entry.getKey() + " находится на полке: " + entry.getValue());
        }
    }
}
