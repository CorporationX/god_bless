package school.faang.BJS2_86133;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString(includeFieldNames = true)
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
