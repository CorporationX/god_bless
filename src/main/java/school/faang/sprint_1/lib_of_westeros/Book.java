package school.faang.sprint_1.lib_of_westeros;

import lombok.AllArgsConstructor;
import java.util.Objects;

@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public boolean equals(Object key) {
        if (this == key) {
            return true;
        }
        if (key == null
                || getClass() != key.getClass()) {
            return false;
        }

        Book book = (Book) key;
        return year == book.year
                && title.equals(book.title)
                && author.equals(book.author);
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