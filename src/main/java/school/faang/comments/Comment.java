package school.faang.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private String text;
    private String author;
    private LocalDateTime localDateTime;
}
