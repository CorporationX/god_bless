package school.faang.writing_comment_BJS2_39160;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;
}