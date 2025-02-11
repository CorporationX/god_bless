package school.faang.sprint1.task_56952;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
