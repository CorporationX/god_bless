package school.faang.library;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
