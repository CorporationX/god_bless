package school.faang.library_of_westeros.BJS2_57001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LibrarySystem ls = new LibrarySystem();
        LOGGER.info("Library System Initialized");

        ls.addBook("Старик и море", "Хемингуэй", 1952, "Полка 4");
        ls.addBook("Мастер и Маргарита", "Михаил Булгаков", 1967, "Полка 2");
        ls.addBook("Война и мир", "Лев Толстой", 1869, "Полка 3");
        ls.addBook("Преступление и наказание", "Фёдор Достоевский", 1866, "Полка 4");
        ls.addBook("Гарри Поттер и философский камень", "Дж. К. Роулинг", 1997, "Полка 1");
        ls.addBook("Маленький принц", "Антуан де Сент-Экзюпери", 1943, "Полка 2");
        LOGGER.info("Adding books");

        ls.removeBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        LOGGER.info("Removing books");

        ls.findBook("Старик и море", "Хемингуэй", 1952);
        ls.findBook("Маленький принц", "Антуан де Сент-Экзюпери", 1943);
        ls.findBook("Мастер и Маргарита", "Михаил Булгаков", 1967);
        LOGGER.info("Searching for books");

        System.out.println("Все книги:");
        ls.printAllBooks();
        LOGGER.info("Printing all books");

    }
}
