package school.faang.bjs245292;

import java.util.HashMap;
import java.util.Map;

public class Main {
    protected static Map<Book, String> libraryVesteros = new HashMap<>();

    public static void main(String[] args) {

        Book book1 = new Book("Black Swan", "N.N.Taleb", 2007);
        Book book2 = new Book("Crime and punishment", "F.M.Dostoevsky", 1866);
        Book book3 = new Book("Harry Potter", "Dj.Rowling", 1990);
        Book book4 = new Book("War and peace", "L.N.Tolstoy", 1867);

        libraryVesteros.put(book1, "231");
        libraryVesteros.put(book2, "220");
        libraryVesteros.put(book3, "290");
        libraryVesteros.put(book4, "230");

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.printAllBooks(libraryVesteros);
        librarySystem.addBook("Master and Margarita", "M.Bulgakov", 1930, "287");
        System.out.println("----------------------------");
        librarySystem.printAllBooks(libraryVesteros);
        librarySystem.removeBook("Crime and punishment", "F.M.Dostoevsky", 1866);
        System.out.println("----------------------------");
        librarySystem.printAllBooks(libraryVesteros);
        System.out.println("----------------------------");
        librarySystem.findBook("War and peace", "L.N.Tolstoy", 1867);
    }
}
