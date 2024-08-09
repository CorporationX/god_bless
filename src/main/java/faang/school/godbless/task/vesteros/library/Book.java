package faang.school.godbless.task.vesteros.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
