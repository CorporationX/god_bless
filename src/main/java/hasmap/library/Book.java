package hasmap.library;

import lombok.Data;
import lombok.NonNull;

@Data
public class Book {
    @NonNull
    private final String title;
    @NonNull
    private final String author;
    private final int year;
}
