package school.faang.bjs2_79677;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import school.faang.util.ParameterUtil;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
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
        if (year != book.year) {
            return false;
        }

        if (title != null ? !title.equals(book.title) : book.title != null) {
            return false;
        }

        if (author != null ? !author.equals(book.author) : book.author != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
