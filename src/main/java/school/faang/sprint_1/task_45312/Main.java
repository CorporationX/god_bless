package school.faang.sprint_1.task_45312;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<Book, String>();

        var book1 = new Book("Преступление и наказание", "Достоевский", 1866);
        var book2 = new Book("Война и мир", "Толстой", 1865);
        var book3 = new Book("Гордость и предубеждение", "Джейн Остин", 1813);

        library.put(book1, "1");
        library.put(book2, "2");
        library.put(book3, "2");

        var librarySystem = new LibrarySystem(library);

        librarySystem.printAllBooks();

        librarySystem.addBook("Муму", "Тургенев", 1854, "1");
        librarySystem.printAllBooks();

        librarySystem.findBook("Гордость и предубеждение", "Джейн Остин", 1813);

        librarySystem.removeBook("Война и мир", "Толстой", 1865);
        librarySystem.printAllBooks();
    }
}
