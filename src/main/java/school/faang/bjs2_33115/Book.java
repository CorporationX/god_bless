package school.faang.bjs2_33115;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return title + " - " + author + " (" + year + ")";
    }
}
