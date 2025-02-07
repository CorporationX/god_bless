package school.faang.task_57071;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String author;
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
