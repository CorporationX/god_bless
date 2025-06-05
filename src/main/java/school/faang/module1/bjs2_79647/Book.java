package school.faang.module1.bjs2_79647;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Book {

    private final String title;
    private final String author;
    private final int year;
}
