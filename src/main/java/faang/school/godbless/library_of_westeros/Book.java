package faang.school.godbless.library_of_westeros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;
}
