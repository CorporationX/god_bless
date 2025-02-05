package school.faang.library_of_westeros;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@Slf4j
@Getter
@NonNull

public class LibrarySystem {

    @Override
    public String toString() {
        return "LibrarySystem{" +
                "locationBook=" + locationBook +
                ", booksName=" + booksName +
                '}';
    }

    static Map<Book, String> locationBook = new HashMap<>();
    private final Map<String, Book> booksName = new HashMap<>();

    public void addBook(String title, String author, int year, String location) {
        if (title == null || author == null || location == null || title.isEmpty()
                || author.isEmpty() || location.isEmpty()) {
            throw new IllegalArgumentException("title, author или location " +
                    " не могут быть null или пустыми");
        }
        if (booksName == null || locationBook == null) {
            throw new IllegalStateException("booksName или locationBook не используются");
        }
        Book book;
        String key = title + author + year;
        if (booksName.containsKey(key)) {
            book = booksName.get(key);
            log.info("книга ({}) изменила локацию на ({})", book, location);
            return;
        } else {
            book = new Book(title, author, year);
            log.info("добавлена новая книга: ({}) с локацией ({})", book, location);
        }
        locationBook.put(book, location);
        booksName.put(key, book);
    }

    public void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        if (locationBook.isEmpty()) {
            System.out.println("в библиотеке нет книг");
            return; // Выход из метода, если коллекция пуста
        }

        if (!locationBook.containsKey(book)) {
            System.out.println("Такой книги нет");
        } else {
            locationBook.remove(book); // Удаление книги
            System.out.println("Книга удалена");
        }
    }

    public String findBook(@NonNull String title, @NonNull String author, int year) {
        Book book = new Book(title, author, year);
        return locationBook.getOrDefault(book, "Книга не найдена");
    }

    public void printAllBooks() {
        for (Map.Entry<Book, String> entry : locationBook.entrySet()) {
            System.out.printf("Книга \"%s\" размещена %s\n",
                    entry.getKey().getTitle(), entry.getValue());
        }

    }
}

