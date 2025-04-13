package school.faang.bjs2_68734;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Book {
    private final String title;
    private final String author;
    private final Integer year;

    protected Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(author, book.author)) return false;
        return Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
