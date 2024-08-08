package faang.school.godbless.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
}
