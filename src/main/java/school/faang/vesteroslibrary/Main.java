package school.faang.vesteroslibrary;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.addBook("Анна Каренина", "Лев Толстой", 1877, "2 полка, 4 ряд");
        librarySystem.addBook("Илон Маск", "Уолтер Айзексон", 2024, "5 полка, 6 ряд");
        librarySystem.addBook("Стив Джобс (в трех частях)", "Уолтер Айзексон", 2011, "4 полка, 6 ряд");
        librarySystem.addBook("Подсознание может всё!", "Джон Кехо", 1997, "3 полка, 2 ряд");
        librarySystem.addBook("Квантовый воин: сознание будущего", "Джон Кехо", 2011, "1 полка, 2 ряд");
        librarySystem.printAllBooks();
        librarySystem.findBook("Квантовый воин: сознание будущего", "Джон Кехо", 2011);

        librarySystem.removeBook("Подсознание может всё!", "Джон Кехо", 1997);
        librarySystem.findBook("Подсознание может всё!", "Джон Кехо", 1997);
        librarySystem.printAllBooks();

    }
}
