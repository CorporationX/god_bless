package school.faang.bjs2_79703;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
