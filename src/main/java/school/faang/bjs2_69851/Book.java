package school.faang.bjs2_69851;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Book book)) {
            return false;
        }

        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                year == book.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Книга \"" + title + "\", " + author + ", " + year;
    }
}
