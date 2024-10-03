package school.faang.vesterousLibrary;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
