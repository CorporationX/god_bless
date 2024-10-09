package school.faang.sprint_1.bjs2_33038;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
