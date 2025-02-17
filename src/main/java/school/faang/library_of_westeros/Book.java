package school.faang.library_of_westeros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {
    private final String title;
    private final String autor;
    private final int year;
}

