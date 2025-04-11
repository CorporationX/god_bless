package school.faang.vesteroslib;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
