package school.faang.task_45356;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        library.addBook("Human", "Bunin", 1948, "12");
        library.addBook("Gambit", "Akunin", 1999, "15");
        library.addBook("Life", "Borisov", 2005, "17");

        library.printAllBooks();
        System.out.println();

        library.addBook("Fetch", "Drow", 2000, "19");
        library.printAllBooks();
        System.out.println();

        library.removeBook("Gambit", "Akunin", 1999);
        library.printAllBooks();
        System.out.println();

        library.findBook("Human", "Bunin", 1948);
    }
}
