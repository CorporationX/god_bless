package school.faang.sprint_1.task_45400;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static school.faang.sprint_1.task_45400.LibrarySystem.addBook;
import static school.faang.sprint_1.task_45400.LibrarySystem.findBook;
import static school.faang.sprint_1.task_45400.LibrarySystem.printAllBooks;
import static school.faang.sprint_1.task_45400.LibrarySystem.removeBook;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            addBook("War and Peace", "Tolstoy", 1873, "Bookshelf 3");
            addBook("Anna Karenina", "Tolstoy", 1877, "Bookshelf 1");
            addBook("The Overcoat", "Gogol", 1842, "Bookshelf 5");
            addBook("Dead Souls", "Gogol", 1842, "Bookshelf 4");

            removeBook("Shining", "King", 1977);

            findBook("War and Peace", "Tolstoy", 1873);

            printAllBooks();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}