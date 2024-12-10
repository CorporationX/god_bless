package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Книга '" + title + "' (автор " + author + ", год издания: " + year + ") ";
    }
}
