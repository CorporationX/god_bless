package school.faang.task57219.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public class Book {
    private String title;
    private String author;
    private int year;
}
