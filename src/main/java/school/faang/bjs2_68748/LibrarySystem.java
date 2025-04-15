package school.faang.bjs2_68748;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private final Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
    }

    public void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public void findBook(String title, String author, int year) {
        System.out.printf("Местоположение книги \"%s (%s, %d)\": %s%n",
                title, author, year, library.getOrDefault(
                        new Book(title, author, year), "Такой книги нет в библиотеке"
                ));
    }

    public void printAllBooks() {
        System.out.println("Все книги в библиотеке:");
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.printf("Книга \"%s (%s, %d)\" находится здесь: %s%n",
                    entry.getKey().title(), entry.getKey().author(), entry.getKey().year(), entry.getValue());
        }
    }
}
