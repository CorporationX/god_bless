package school.faang.vesteros_library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Book {

    private String title;
    private String author;
    private int year;
}
