package school.faang.BJS2_57146;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private static final Map<Book, String> LIBRARY = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        isValid(title, author);
        Book book = new Book(title, author, year);
        LIBRARY.put(book, location);
        System.out.println("Вы добавили книгу " + book + " на полку " + location);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (LIBRARY.containsKey(book)) {
            LIBRARY.remove(book);
            System.out.println("Книга " + book + " успешно удалена");
        } else {
            System.out.println("Извините, но такой книги в библиотеке нет");
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
        StringBuilder allBooks = new StringBuilder();
        System.out.println("В библиотеке имеются:");
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            allBooks.append(entry.getKey())
                    .append(" полка ").append(entry.getValue()).append("\n");
        }
        System.out.println(allBooks);
    }

    private void validatingTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title");
        }
    }

    private void validatingAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Invalid author");
        }
    }

    private void isValid(String title, String author) {
        validatingTitle(title);
        validatingAuthor(author);
    }
}
