package faang.school.godbless.index;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;
}
