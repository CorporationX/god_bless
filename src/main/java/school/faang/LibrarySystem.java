package school.faang;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LibrarySystem {
    private final Map<Book, String> bookLocationMap = new HashMap<>();

    public static class Book {
        private final String title;
        private final String author;
        private final int year;

        public Book(String title, String author, int year) {
            this.title = Objects.requireNonNull(title, "Название книги не может быть null");
            this.author = Objects.requireNonNull(author, "Автор не может быть null");
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return year == book.year &&
                    title.equals(book.title) &&
                    author.equals(book.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, author, year);
        }

        @Override
        public String toString() {
            return String.format("\"%s\" by %s (%d)", title, author, year);
        }
    }



    public void findBook(String title, String author, int year) {
        Objects.requireNonNull(title, "Название книги не может быть null");
        Objects.requireNonNull(author, "Автор не может быть null");

        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным числом");
        }

        Book searchKey = new Book(title, author, year);
        String location = bookLocationMap.get(searchKey);

        if (location != null) {
            System.out.printf("Книга \"%s\" автора %s (%d год) находится на полке: %s%n",
                    title, author, year, location);
        } else {
            System.out.printf("Книга \"%s\" автора %s (%d год) не найдена в библиотеке.%n",
                    title, author, year);
        }
    }

    public String removeBook(String title, String author, int year) {
        Objects.requireNonNull(title, "Название книги не может быть null");
        Objects.requireNonNull(author, "Автор не может быть null");

        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным числом");
        }

        Book bookToRemove = new Book(title, author, year);
        return bookLocationMap.remove(bookToRemove);
    }

    public boolean containsBook(Book book) {
        return bookLocationMap.containsKey(Objects.requireNonNull(book));
    }

    public int getBookCount() {
        return bookLocationMap.size();
    }

    public void printAllBooks() {
        System.out.println("Каталог библиотеки:");
        bookLocationMap.forEach((book, location) ->
                System.out.printf("%-40s → Полка: %s%n", book, location));
    }
}