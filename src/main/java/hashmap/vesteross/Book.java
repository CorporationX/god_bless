package hashmap.vesteross;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private int year;
}
