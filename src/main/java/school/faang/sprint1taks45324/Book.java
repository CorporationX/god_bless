package school.faang.sprint1taks45324;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;
}