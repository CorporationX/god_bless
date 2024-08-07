package faang.school.godbless.LibraryOfWesteros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Book {
    private String title;
    private String author;
    private int year;
}
