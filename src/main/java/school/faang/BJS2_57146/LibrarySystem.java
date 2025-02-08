package school.faang.BJS2_57146;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        Book book = new Book(title, author, year);
        LIBRARY.put(book, location);
        System.out.println("Вы добавили книгу " + book + " на полку " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (LIBRARY.containsKey(book)) {
            LIBRARY.remove(book);
            System.out.println("Книга " + book + " успешно удалена");
        }
    }

    public void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        String location = LIBRARY.get(book);
        if (location != null) {
            System.out.println("Книга " + book + " находится на полке " + location);
        } else {
            System.out.println("Извините, но такой книги нет!");
        }
    }

    public void printAllBooks() {
        System.out.println("В библиотеке имеются:");
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            System.out.println(entry.getKey() + " полка " + entry.getValue());
        }
    }
}
