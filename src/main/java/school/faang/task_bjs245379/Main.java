package school.faang.task_bjs245379;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        LibrarySystem.addBook("Война и мир", "Толстой", 1869, "классика 5 ряд");
        LibrarySystem.addBook("Преступление и наказание", "Достоевский", 1866, "классика 3 ряд");
        LibrarySystem.addBook("Мастер и Маргарита", "Булгаков", 1940, "классика 4 ряд");
        LibrarySystem.addBook("Оно", "Кинг", 1986, "ужасы 1 ряд");
        LibrarySystem.addBook("Зеленая миля", "Кинг", 1996, "ужасы 1 ряд");
        LibrarySystem.addBook("Под куполом", "Кинг", 2009, "ужасы 1 ряд");

        LibrarySystem.printAllBooks();
        System.out.println();
        LibrarySystem.removeBook("Война и мир", "Толстой", 1869);
        LibrarySystem.printAllBooks();
        System.out.println(LibrarySystem.findBook("Оно", "Кинг", 1986));
    }
}
