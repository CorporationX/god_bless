package school.faang.sprint1.collections.vesteroslibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
