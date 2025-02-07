package school.faang.libraryw;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;

    @Override
    public String toString() {
        return "Название: \"" + title + "\"" +
                ", автор: \"" + author + "\"" +
                ", год издания: " + year;
    }
}