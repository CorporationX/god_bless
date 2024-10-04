package school.faang.library_of_vesteros_BJS2_33021;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        library.putAll(Map.of(
                new Book("Bible", "Jesus", 0), "shelf_1",
                new Book("Война и мир", "Толстой", 1900), "shelf_2",
                new Book("Преступление и наказание", "Достоевский", 1850), "shelf_1"
        ));

        addBook(new Book("Java", "Mask", 2023), "shelf_5");
        printAllBooks();
        deleteBook("Война и мир", "Толстой", 1900);
        printAllBooks();
        findBook("Bible", "Jesus", 0);
        System.out.println("-".repeat(15));
        printAllBooks();
    }

    public static void addBook(Book book, String shelf) {
        library.put(book, shelf);
        System.out.println("Книга успешно добавлена!");
    }

    public static void deleteBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
        System.out.println("Книга успешно удалена");
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.printf("Книга %s автора %s (%d) находится на полке %s\n", title, author, year, library.get(book));
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            String title = entry.getKey().getTitle();
            String author = entry.getKey().getAuthor();
            int year = entry.getKey().getYear();
            String shelf = entry.getValue();
            System.out.printf("Книга %s автора %s (%d) находится на полке %s\n", title, author, year, shelf);
        }
    }

}
