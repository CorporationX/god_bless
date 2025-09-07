package school.faang.BJS2_86133;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
