package westeros.biblioteque;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Book {
    private String title;
    private String author;
    private int year;
}
