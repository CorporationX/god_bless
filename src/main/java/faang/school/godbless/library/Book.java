package faang.school.godbless.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@RequiredArgsConstructor
@Setter
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
