package school.faang.libraryofwesteros;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Book {
    private String tittle;
    private String author;
    private int year;
}