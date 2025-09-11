package school.faang.bjs2_86153;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
