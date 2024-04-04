package faang.school.godbless.vesterossLibrary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Book: " + title + ", "
                + author + ", " + year;
    }

}
