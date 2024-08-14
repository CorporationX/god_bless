package faang.school.godbless.java.sql.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;

}
