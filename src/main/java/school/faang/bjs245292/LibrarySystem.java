package school.faang.bjs245292;

import java.util.Map;

public class LibrarySystem {
    protected static void addBook(String title, String author, int year, String location) {
        Main.libraryVesteros.put(new Book(title, author, year), location);
    }

    protected static void removeBook(String title, String author, int year) {
        Main.libraryVesteros.remove(new Book(title, author, year));
    }

    protected static void findBook(String title, String author, int year) {
        if (Main.libraryVesteros.containsKey(new Book(title, author, year))) {
            System.out.println(Main.libraryVesteros.get(new Book(title, author, year)));
        } else {
            System.out.println("Данная книга отсутствует в библиотеке");
        }
    }

    protected static void printAllBooks(Map<Book, String> library) {
        library.forEach(((book, location) -> System.out.println(book + " : " + location)));
    }
}
