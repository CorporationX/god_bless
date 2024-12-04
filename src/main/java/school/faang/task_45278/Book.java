package school.faang.task_45278;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;
}