package school.faang.bjs2_86142;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public class Book {

    private final String title;
    private final String author;
    private final int year;
}
