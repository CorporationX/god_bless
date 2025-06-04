package school.faang.module1.bjs2_79647;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Book {

    private final String title;
    private final String author;
    private final int year;

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Book book = (Book) object;
        return year == book.year
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }
}
