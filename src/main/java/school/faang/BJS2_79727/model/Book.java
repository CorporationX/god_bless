package school.faang.BJS2_79727.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Year;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private Year year;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
