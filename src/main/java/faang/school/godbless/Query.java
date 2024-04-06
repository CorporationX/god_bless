package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;
}
