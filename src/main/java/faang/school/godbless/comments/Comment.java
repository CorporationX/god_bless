package faang.school.godbless.comments;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private LocalDateTime time;
    private String author;


}
