package school.faang.s12task45289;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}