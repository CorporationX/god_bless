package school.faang.naughtwoBJS257210;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Year;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        if (title.isBlank()
                || author.isBlank()
                || year < 0 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Incorrect data entered");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Book '%s. %s. %d'",
                this.getTitle(), this.getAuthor(), this.getYear());
    }
}
