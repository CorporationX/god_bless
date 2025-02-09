package school.faang.task_59080;

import static school.faang.task_59080.LibrarySystem.addBook;
import static school.faang.task_59080.LibrarySystem.findBook;
import static school.faang.task_59080.LibrarySystem.printAllBooks;
import static school.faang.task_59080.LibrarySystem.removeBook;

public class Main {
    public static void main(String[] args) {
        addBook("1984", "George Orwell", 1949, "Shelf 1");
        addBook("To Kill a Mockingbird", "Harper Lee", 1960, "Shelf 2");
        addBook("Moby-Dick", "Herman Melville", 1851, "Shelf 3");

        removeBook("To Kill a Mockingbird", "Harper Lee", 1960);

        findBook("1984", "George Orwell", 1949);
        findBook("To Kill a Mockingbird", "Harper Lee", 1960);
        findBook("Moby-Dick", "Herman Melville", 1851);

        printAllBooks();
    }
}

