package school.faang.library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("Грокаем алгоритмы", "Адитьч Бхаргава", 2019, "Дома");
        librarySystem.findBook("Грокаем алгоритмы", "Адитьч Бхаргава", 2019);
        librarySystem.printAllBooks();
        librarySystem.removeBook("Грокаем алгоритмы", "Адитьч Бхаргава", 2019);
    }
}
