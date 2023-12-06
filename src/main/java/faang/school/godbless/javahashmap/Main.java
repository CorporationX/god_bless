package faang.school.godbless.javahashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> library = new HashMap<>();
    public static void main(String... args) {
        initLibrary();
    }

    public  static void initLibrary() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);

        library.put(book1, "Полки");
        library.put(book2, "Шкаф");
        library.put(book3, "Стол");

        System.out.println("Книги добавлены в библиотеку");
    }

    public static void addBook(Book book, String place) {
        library.put(book, place);
    }

    public  static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book));
        } else {
            System.out.println("");
        }
    }
}
