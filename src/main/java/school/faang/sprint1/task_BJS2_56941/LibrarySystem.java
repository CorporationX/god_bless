package school.faang.sprint1.task_BJS2_56941;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LibrarySystem {
    private final Map<Book, String> booksOnShelf = new HashMap<>();
    private final int maxYear = 2025;
    private final int minYear = 0;

    public void addBook(@NonNull String title, @NonNull String author,
                        int year, @NonNull String location) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("title не может быть пустым");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("author не может быть пустым");
        }
        if (location.isEmpty()) {
            throw new IllegalArgumentException("location не может быть пустым");
        }
        if (year < minYear || year > maxYear) {
            throw new IllegalArgumentException("Не валидный год книги : " + year);
        }

        Book book = new Book(title, author, year);
        booksOnShelf.put(book, location);
    }

    public void removeBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("title не может быть пустым");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("author не может быть пустым");
        }
        if (year < 0 || year > 2025) {
            throw new IllegalArgumentException("Не валидный год книги : " + year);
        }

        Book book = new Book(title, author, year);
        booksOnShelf.remove(book);
    }

    public void findBook(@NonNull String title, @NonNull String author, int year) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("title не может быть пустым");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("author не может быть пустым");
        }

        Book book = new Book(title, author, year);
        if (booksOnShelf.containsKey(book)) {
            System.out.printf("Книга %s находится на %s\n", book, booksOnShelf.get(book));
        } else {
            System.out.printf("Книги %s нет в библиотеке\n", book);
        }
    }

    public void printAllBooks() {
        System.out.println(booksOnShelf);
    }
}
