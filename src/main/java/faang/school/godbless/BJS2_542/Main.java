package faang.school.godbless.BJS2_542;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book("Великий Гэтсби", "Фрэнсис Скотт Фицджеральд", 1925);
        Book book2 = new Book("Убить пересмешника", "Харпер Ли", 1960);
        Book book3 = new Book("1984", "Джордж Оруэлл", 1949);

        addBook(book1, "Shelf A");
        addBook(book2, "Shelf B");
        addBook(book3, "Shelf C");

        infoAllBook();
    }
    public static void addBook (Book book, String location) {
        library.put(book, location);
    }
    public static void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void infoBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = library.get(book);
        if (location == null)
            throw new NoSuchElementException("Book not found");

        System.out.printf("Location of book: %s is: \" %s \"", book, location);
    }
    public static void infoAllBook() {
        System.out.println("Here are all the books: \n");
        library.forEach((book, location) -> System.out.printf("Location of book \"%s\" is: \"%s\"%n", book, location));
    }
}
