package faang.school.godbless.task7;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private Integer year;

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof Book compareTo) {
            return this.title.equals(compareTo.title) &&
                   this.author.equals(compareTo.author) &&
                   this.year.equals(compareTo.year);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
