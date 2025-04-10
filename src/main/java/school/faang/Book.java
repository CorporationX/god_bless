package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private final Map<LibrarySystem.Book, String> bookLocationMap = new HashMap<>();

    // Конструктор, геттеры и сеттеры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public void addBook(String title, String author, int year, String location) {
        Objects.requireNonNull(title, "Название книги не может быть null");
        Objects.requireNonNull(author, "Автор не может быть null");
        Objects.requireNonNull(location, "Местоположение не может быть null");

        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным числом");
        }
    }

    public void findBook(String title, String author, int year) {
        Objects.requireNonNull(title, "Название книги не может быть null");
        Objects.requireNonNull(author, "Автор не может быть null");

        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным числом");
        }

        LibrarySystem.Book searchKey = new LibrarySystem.Book(title, author, year);
        String location = bookLocationMap.get(searchKey);

        if (location != null) {
            System.out.printf("Книга \"%s\" автора %s (%d год) находится на полке: %s%n",
                    title, author, year, location);
        } else {
            System.out.printf("Книга \"%s\" автора %s (%d год) не найдена в библиотеке.%n",
                    title, author, year);
        }
    }
}