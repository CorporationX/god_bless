package school.faang.sprint_1.task_bjs45348;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@ToString
@RequiredArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author)
            && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
