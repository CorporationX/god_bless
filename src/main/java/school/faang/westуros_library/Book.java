package school.faang.westуros_library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
public class Book {
    private String title;
    private String author;
    private int year;
}