package school.faang.bjs2_69851;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Книга \"" + title + "\", " + author + ", " + year;
    }
}
