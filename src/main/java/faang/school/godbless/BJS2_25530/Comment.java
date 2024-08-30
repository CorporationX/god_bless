package faang.school.godbless.BJS2_25530;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class Comment {
    private String author;
    private String text;
    private LocalDateTime dateTime;
}
