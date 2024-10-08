package school.faang.BJS2_33136;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Book book = (Book) obj;
            return year == book.year &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}
