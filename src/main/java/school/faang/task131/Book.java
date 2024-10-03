package school.faang.task131;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Data
@ToString
public class Book {

    private String title;
    private String author;
    private int year;
}
