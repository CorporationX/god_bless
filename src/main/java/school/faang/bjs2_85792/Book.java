package school.faang.bjs2_85792;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return " Book-" +
                "title:" + title +
                "author:'" + author +
                "year:" + year + " ";
    }
}
