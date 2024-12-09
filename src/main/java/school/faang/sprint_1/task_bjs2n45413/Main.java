package school.faang.sprint_1.task_bjs2n45413;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {
    public static void main(String[] args) {
        try {
            Map<Book, String> hashMap = Map.ofEntries(
                    entry(new Book("Book One", "Petrov V.A.", 2018), "shelf 1"),
                    entry(new Book("Book Two", "Petrov V.A.", 2019), "shelf 1"),
                    entry(new Book("Book Three", "Ivanov P.P.", 2010), "shelf 2")
            );

            Map<Book, String> mutableMap = new HashMap<>((hashMap));
            mutableMap.put(new Book("Book Four", "Ivanov P.P.", 2011), "shelf 3");

            LibrarySystem librarySystem = new LibrarySystem(mutableMap);
            librarySystem.printAllBooks();

            librarySystem.addBook("Избранное", "Пушкин А.С.", 2015, "shelf 2");
            System.out.println("\naddBook");
            librarySystem.printAllBooks();

            librarySystem.addBook("Избранное", "Пушкин А.С.", 2015, "shelf 2");
            System.out.println("\naddBook дубликат: ");
            librarySystem.printAllBooks();

            System.out.println("\nfindBook:");
            librarySystem.findBook("Избранное", "Пушкин А.С.", 2015);
            librarySystem.findBook("Избранное", "Пушкин А.С.", 2014);

            System.out.println("\nПроверка на неверные значения(год) при создании книги и выброс exception:");
            librarySystem.addBook("Избранное", "Пушкин А.С.", 2115, "shelf 2");
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }
}
