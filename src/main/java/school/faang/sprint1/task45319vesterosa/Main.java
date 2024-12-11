package school.faang.sprint1.task45319vesterosa;

import java.util.HashMap;
import java.util.Map;

import static school.faang.sprint1.task45319vesterosa.LibrarySystem.*;

public class Main {
    public static Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book harryPotter = new Book("Гарри Поттер", "Автор1", 1997);
        Book idiot = new Book("Идиот", "Достоевский", 1998);

        library.put(harryPotter, "Первая полка");
        library.put(idiot, "Вторая полка");

        addBook("Book1", "Author1", 2002, "Вторая полка");
        findBook(harryPotter);
        removeBook("Book1", "Author1", 2002);
        removeBook("Book1", "Author2", 2002);
        addBook(harryPotter, "Вторая полка");
        printAllBooks();

    }
}

