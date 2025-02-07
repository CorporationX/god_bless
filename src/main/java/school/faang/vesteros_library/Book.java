package school.faang.vesteros_library;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {

    private String title;
    private String author;
    private int year;
}
