package school.faang.libraryw;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private final String TITLE;
    private final String AUTHOR;
    private final int YEAR;

    @Override
    public String toString() {
        return "Название: \"" + TITLE + "\"" +
                ", автор: \"" + AUTHOR + "\"" +
                ", год издания: " + YEAR;
    }
}
