package faang.school.godbless.library;

import lombok.Data;
import lombok.ToString;

@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;
}