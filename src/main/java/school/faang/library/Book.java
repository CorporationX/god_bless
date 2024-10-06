package school.faang.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author) && year == other.year;
    }
}
