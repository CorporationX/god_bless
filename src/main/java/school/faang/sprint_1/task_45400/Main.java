package school.faang.sprint_1.task_45400;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            LibrarySystem librarySystem = new LibrarySystem();

            librarySystem.addBook("War and Peace", "Tolstoy", 1873, "Bookshelf 3");
            librarySystem.addBook("Anna Karenina", "Tolstoy", 1877, "Bookshelf 1");
            librarySystem.addBook("The Overcoat", "Gogol", 1842, "Bookshelf 5");
            librarySystem.addBook("Dead Souls", "Gogol", 1842, "Bookshelf 4");

            librarySystem.removeBook("Shining", "King", 1977);

            librarySystem.findBook("War and Peace", "Tolstoy", 1873);

            librarySystem.printAllBooks();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}