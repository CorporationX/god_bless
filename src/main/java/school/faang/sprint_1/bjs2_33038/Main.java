package school.faang.sprint_1.bjs2_33038;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addBook(Book book, String shelf) {
        library.put(book, shelf);
    }

    public static void deleteBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static String findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return library.getOrDefault(book, "Книга не найдена");
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            String title = entry.getKey().getTitle();
            String author = entry.getKey().getAuthor();
            int year = entry.getKey().getYear();
            String shelf = entry.getValue();
            System.out.printf("Книга '%s' автора '%s' (%d года) находится на полке '%s\n'", title, author, year, shelf);
        }
    }
}