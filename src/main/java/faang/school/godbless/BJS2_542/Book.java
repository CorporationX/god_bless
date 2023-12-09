package faang.school.godbless.BJS2_542;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "title: " + title + ", "+
               "author " + author + ", " +
               "year " + year;
    }
}
