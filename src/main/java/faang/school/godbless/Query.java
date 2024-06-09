package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;
}
