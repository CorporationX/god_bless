package faang.school.godbless.BJS2_25597;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private String text;
    private LocalDateTime time;
    private String author;
}
