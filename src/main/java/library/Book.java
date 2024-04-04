package library;

import java.util.Objects;

public class Book {
    private final String title;
    private final String autor;
    private final int year;

    public Book(String title, String autor, int year) {
        this.title = title;
        this.autor = autor;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autor, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(autor, book.autor);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                '}';
    }
}
