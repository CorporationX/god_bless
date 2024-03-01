package faang.school.godbless.leavecomments;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {

    private String text;
    private LocalDateTime dateTime;
    private String author;
}
