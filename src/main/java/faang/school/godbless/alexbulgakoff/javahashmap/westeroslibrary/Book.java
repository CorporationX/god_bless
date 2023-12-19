package faang.school.godbless.alexbulgakoff.javahashmap.westeroslibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    private String title;

    private String author;

    private String year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
