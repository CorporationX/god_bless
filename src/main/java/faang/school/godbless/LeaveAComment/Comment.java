package faang.school.godbless.LeaveAComment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class Comment {
    private int id;
    private String text;
    private LocalDateTime dateTime;
    private String author;
}
