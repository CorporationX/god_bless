package school.faang.bjs2_86260_1_1_3_1_vesteros_library;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Book {
    @Getter
    private String title;
    private String author;
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(year,
                book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
