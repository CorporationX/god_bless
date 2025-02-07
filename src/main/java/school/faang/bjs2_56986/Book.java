package school.faang.bjs2_56986;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private int year;
}
