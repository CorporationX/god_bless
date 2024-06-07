package faang.school.godbless.westeros_library;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@AllArgsConstructor
public class Book {
    String title;
    String author;
    int year;

    @Override
    public int hashCode() {
        return Objects.hash(year, title, author);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book other) {
            return year == other.year && title.equals(other.title) && author.equals(other.author);
        }
        return false;
    }
}
