package school.faang.libary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class Book {
    private String tittle;
    private String author;
    private int year;
}
