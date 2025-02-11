package school.faang.westeroslibrary;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private Map<Book, String> library = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        library.put(new Book(title, author, year), location);
        System.out.println("Книга добавлена успешно в локацию: " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println("Книга удалена успешно");
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println("Книга " + book.toString() + " найдена в локации: ");
            System.out.println(library.get(book));
        } else {
            System.out.println("Книга не найдена");
        }
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга: " + entry.getKey().toString());
            System.out.println("Ее местонахождение: " + entry.getValue());
            System.out.println();
        }
    }
}
