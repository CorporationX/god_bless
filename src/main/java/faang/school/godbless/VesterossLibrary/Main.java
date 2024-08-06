package faang.school.godbless.VesterossLibrary;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Main {
    private static final Map<Book, String> VesterossLibrary = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        addBookToLibrary(new Book("1984", "George Orwell", 1949));
        addBookToLibrary(new Book("Brave New World", "Aldous Huxley", 1932));
        addBookToLibrary(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));

        System.out.println("Местоположение '1984': " + findBookFromLibrary("1984", "George Orwell", 1949));

        // Удаление книги
        removeBookFromLibrary("Brave New World", "Aldous Huxley", 1932);

        // Список всех книг
        listAllBooks();

    }

    public static void addBookToLibrary(Book book) {

        VesterossLibrary.put(book, String.valueOf(random.nextInt(15)));
    }

    public static void removeBookFromLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        VesterossLibrary.remove(book);
    }

    public static String findBookFromLibrary(String title, String author, int year) {
        Book book = new Book(title, author, year);
        return VesterossLibrary.get(book);
    }

    public static void listAllBooks() {
        Set<Map.Entry<Book, String>> entries = VesterossLibrary.entrySet();
        for (Map.Entry<Book, String> entry : entries) {
            System.out.println(entry.getKey() + " находится на полке " + entry.getValue());
        }
    }


}
