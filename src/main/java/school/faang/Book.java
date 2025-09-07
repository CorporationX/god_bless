package school.faang;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object bootToCheck) {
        if (!(bootToCheck instanceof Book book)) {
            return false;
        }
        return Objects.equals(book.title, this.title) && Objects.equals(book.author, this.author) && Objects.equals(book.year, this.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "title:'" + title + "', author:'" + author + "', year:" + year + " ";
    }

}
