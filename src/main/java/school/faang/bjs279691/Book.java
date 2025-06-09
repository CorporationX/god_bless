package school.faang.bjs279691;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return title + " " + author + " " + year;
    }
}
