package school.faang.bjs2_86123;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;
}
