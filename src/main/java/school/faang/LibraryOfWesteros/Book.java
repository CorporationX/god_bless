package school.faang.LibraryOfWesteros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


import java.util.Objects;
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private String title;
    private String author;
    private int year;
}
